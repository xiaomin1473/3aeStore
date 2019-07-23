package store.ae.server.parse;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import store.ae.server.common.ErrorCode;
import store.ae.server.core.TcpServer;
import store.ae.server.dto.Response;
import store.ae.server.utils.DataUtil;

public class BaseParse {

	/**
	 * 实例化日志对象.
	 */
	protected static final Logger logger = LoggerFactory.getLogger(TcpServer.class);
	
	
	/**
	 * 命令.
	 */
	protected int command;
	
	
	
	protected Map<String, Channel> client;

	/**
	 * 通信IP.
	 */
	protected String devIp;

	/**
	 * 设备类型.
	 */
	protected int devType;

	/**
	 * 信息对象.
	 */
	protected byte[] obj;

	/**
	 * 信息对象数目.
	 */
	protected int objNum;

	/**
	 * 类型标志.
	 */
	protected int objType;

	/**
	 * 数据包流水号.
	 */
	protected int pkgSN;
	
	
	
	/**
	 * 错误码
	 */
	private int errorCode = ErrorCode.PKG.SUCCESS;

	/**
	 * 同步锁.
	 */
	private CountDownLatch latch = null;

	/**
	 * 回复的信息对象.
	 */
	private Object resObj = null;
	
	
	
	public void setParams(String clientIp, int command, int devType, byte[] obj, int objNum, int objType, int pkgSN) {
		// 客户端IP
		devIp = clientIp;
		this.command = command;
		this.devType = devType;
		this.obj = obj;
		this.objNum = objNum;
		this.objType = objType;
		this.pkgSN = pkgSN;
	}
	
	public void setClient(Map<String, Channel> client) {
		this.client = client;
	}
	
	

	
	
	private byte[] getData(int pkgSN, int command, int objType, int devType, byte[] obj) {
		// 信息对象长度
		int objLen = obj == null ? 0 : obj.length;
		// 包长
		int len = 17 + objLen;
		byte[] datas = new byte[len];
		// 启动符
		datas[0] = '@';
		datas[1] = '@';
		// 数据包流水号
		byte[] arr = DataUtil.int2byteArr(pkgSN, 2);
		datas[2] = arr[0];
		datas[3] = arr[1];
		// 应用数据单元长度
		arr = DataUtil.int2byteArr(objLen + 5, 4);
		for (int i = 0; i < 4; i++) {
			datas[4 + i] = arr[i];
		}
		// 命令字节
		datas[8] = (byte) command;
		// 类型标志
		arr = DataUtil.int2byteArr(objType, 2);
		datas[9] = arr[0];
		datas[10] = arr[1];
		// 设备类型
		arr = DataUtil.int2byteArr(devType, 2);
		datas[11] = arr[0];
		datas[12] = arr[1];
		// 信息对象数目
		if (objLen == 0) {
			datas[13] = (byte) 0;
		} else {
			if (objType == 36) {
				// 发射器参数 有多个信息对象
				datas[13] = (byte) (objLen / 7);
			} else {
				datas[13] = (byte) 1;
			}
			// 信息对象
			for (int i = 0; i < objLen; i++) {
				datas[14 + i] = obj[i];
			}
		}
		// 校验和
		datas[14 + objLen] = (byte) DataUtil.checkSum(datas);
		// 结束符
		datas[15 + objLen] = '#';
		datas[16 + objLen] = '#';
		return datas;
	}
	
	public int sendVoid(String devIp, int pkgSN, int command, int objType, int devType, byte[] objs) throws Exception {
		// 检测设备是否在线
		//Channel channel = null;
		Channel channel = check(devIp);
		if (channel == null) {
			return -1;
		}
		byte[] datas = getData(pkgSN, command, objType, devType, objs);
		channel.writeAndFlush(Unpooled.copiedBuffer(datas));
		logger.info("发送 {} 到: {}, 数据: {}", DataUtil.getCommand(command), devIp, DataUtil.byteArr2StringHex(datas));
		return 1;
	}
	
	private Channel check(String devIp) throws Exception {
		Channel channel = client.get(devIp);
		if (channel == null || !channel.isWritable()) {
			logger.error("设备IP={}不在线", devIp);
			return null;
		} else {
			return channel;
		}
	}
	
	public Response send(String devIp, int pkgSN, int command, int objType, int devType, byte[] obj) throws Exception {
		// 返回报文
		Response res = new Response();
		try {
			// 检测设备是否在线
			Channel channel = check(devIp);
			if (channel == null) {
				res.setCode(ErrorCode.PKG.DEV_IDLE);
				return res;
			}
			// 发送数据
			byte[] datas = getData(pkgSN, command, objType, devType, obj);
			String log = "发送 " + DataUtil.getCommand(command) + " 到: " + devIp + ", 数据: "
					+ DataUtil.byteArr2StringHex(datas);
			// 发送次数
			int count = 0;
			while (count <= 3) {
				if (count == 0) {
					logger.info(log);
				} else {
					logger.info("第{}重发.{}", count, log);
				}
				count++;
				latch = new CountDownLatch(1);
				// 获取等待该报文标识的回复的队列
				channel.writeAndFlush(Unpooled.copiedBuffer(datas));
				boolean ret = latch.await(3000, TimeUnit.SECONDS);
				if (ret) {
					res.setCode(errorCode);
					res.setResObj(resObj);
					return res;
				} else {
					// 超时
					res.setCode(ErrorCode.PKG.TIMEOUT);
				}
			}
		} finally {
		}
		return res;
	}
}
