package store.ae.server.parse;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;
import store.ae.server.common.Constants;
import store.ae.server.common.Symbol;
import store.ae.server.utils.DataUtil;

public class Regist extends BaseParse {

	
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


	public int run() {
		try {
			logger.info("注册包");
			// 设备序列号
			String devSN = "";
			// 设备类型
			devSN += DataUtil.toString((obj[0] & 0xFF) | ((obj[1] & 0xFF) << 8), 4) + Symbol.Common.SPLIT;
			// 生产年份
			devSN += DataUtil.toString(obj[2] & 0xFF, 2) + Symbol.Common.SPLIT;
			// 生产月份
			devSN += DataUtil.toString(obj[3] & 0xFF, 2) + Symbol.Common.SPLIT;
			// 生产日
			devSN += DataUtil.toString(obj[4] & 0xFF, 2) + Symbol.Common.SPLIT;
			// 流水号
			devSN += DataUtil.toString((obj[5] & 0xFF) | ((obj[6] & 0xFF) << 8), 4);

			// 通信协议版本
			String protocolVer = "";
			// 通信协议版本
			// 主版本
			protocolVer += (obj[7] & 0xFF) + Symbol.Common.DOT;
			// 次版本
			protocolVer += (obj[8] & 0xFF) + " ";
			// 年
			protocolVer += DataUtil.toString(obj[9] & 0xFF, 2) + Symbol.Common.SPLIT;
			// 月
			protocolVer += DataUtil.toString(obj[10] & 0xFF, 2) + Symbol.Common.SPLIT;
			// 日
			protocolVer += DataUtil.toString(obj[11] & 0xFF, 2);

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("devSN", devSN);
			param.put("protocolVer", protocolVer);
			// 回复包
			logger.info("{}", param.toString());
			sendVoid(devIp, pkgSN, Constants.Command.CMD_7, 0, devType, replyObjs());
			return 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}
	
	/**
	 * 回复信息对象字节数组.
	 * 
	 * @return 回复信息对象字节数组
	 */
	private byte[] replyObjs() {
		// 信息对象
		byte[] replyObjs = new byte[140];
		for (int i = 0; i < 12; i++) {
			replyObjs[i] = obj[i];
		}
		// 随机字段
		int sum = 0;
		for (int i = 0; i < 128; i++) {
			sum += obj[12 + i] & 0xFF;
		}
		sum = sum & 0xFF;
		for (int i = 0; i < 128; i++) {
			replyObjs[12 + i] = (byte) (obj[12 + i] ^ ((byte) sum & 0xFF));
		}
		return replyObjs;
	}

}
