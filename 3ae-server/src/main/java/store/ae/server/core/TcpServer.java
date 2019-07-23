package store.ae.server.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import store.ae.server.common.ConfigUtil;
import store.ae.server.parse.AnalyState;
import store.ae.server.parse.ImgFind;
import store.ae.server.parse.Regist;

@Sharable
public class TcpServer extends ChannelInboundHandlerAdapter {
	
	/**
	 * 实例化日志对象.
	 */
	private static final Logger logger = LoggerFactory.getLogger(TcpServer.class);
	
	
	private Map<String, Channel> client = new HashMap<String, Channel>();
	
	private Regist regist = new Regist();
	private AnalyState analyState = new AnalyState();
	private ImgFind imgFind = new ImgFind();
	
	/**
	 * 接收到的字节缓存
	 */
	private List<Byte> revBuf = Collections.synchronizedList(new ArrayList<Byte>());

	/**
	 * 报文剩余读取字节数.
	 */
	private int lessLen = 0;

   /**
    * 
    * 客户端与服务端创建连接的时候调用。激活连接，每个连接只会调用一次。
    * 
    */
   @Override
   public void channelActive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.add(ctx.channel());
	   
	   Channel channel = ctx.channel();
	   String clientIp = ctx.channel().remoteAddress().toString().split("/")[1].split(":")[0];
	   
	   client.put(clientIp, channel);
	   
	   System.out.println("\n【连接状态】" + ctx);

   }

   /**
    * 客户端与服务端断开连接时调用
    */
   @Override
   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.remove(ctx.channel());
	   
	   System.out.println("\n【连接状态】" + ctx.channel().remoteAddress() + "\t 已关闭");
   }

   /**
    *  任何信息入站都会调用该方法。
    *  服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
    */
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	   ByteBuf in = (ByteBuf) msg;
	   Integer len = in.readableBytes();
	   byte[] bytes = null;
	   
	   String clientIp = ctx.channel().remoteAddress().toString().split("/")[1].split(":")[0];
	   
	   System.out.println("【服务管理】已与客户端 " + clientIp + " 建立连接!");
	   System.out.println("【建立时间】" + getTime());

	   // 直接缓存区
	   if (!in.hasArray()) { 
		   // 字节数组转字符
		   bytes = new byte[len];
		   in.getBytes(in.readerIndex(), bytes);
	   }
	   
       
	   // 命令行输出
	   System.out.println("\n【新短消息】" + ctx.channel().remoteAddress() + "发来消息");
	   System.out.println("【接收时间】" + getTime());
	   
	   for (int i = 0; i < len; i++) {
			if (revBuf.size() <= 1) {
				if ((bytes[i] & 0xFF) != '@') {
					return;
				}
			}
			revBuf.add(bytes[i]);
			if (lessLen == 0) {
				if (revBuf.size() == 8) {
					lessLen = ((revBuf.get(4) & 0xFF) | ((revBuf.get(5) & 0xFF) << 8)
							| ((revBuf.get(6) & 0xFF) << 16) | ((revBuf.get(7) & 0xFF) << 24)) + 4;
				}
			} else {
				lessLen--;
				if (lessLen == 0) {
					byte[] datas = new byte[revBuf.size()];
					for (int j = 0; j < datas.length; j++) {
						datas[j] = revBuf.get(j);
					}
					revBuf.clear();
					parse(clientIp, datas);
				}
			}
		}
	   
	   ReferenceCountUtil.release(msg);
   }

   /**
    * 服务端接收客户端发送过来的数据结束之后调用
    */
   @Override
   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	   //ctx.write(Unpooled.copiedBuffer("服务器主动关闭连接!", CharsetUtil.UTF_8));
	   ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	   ctx.flush();
	   //ctx.close();
	   //System.out.println(SERVER_INFO + ctx.channel().remoteAddress().toString() + "数据读取已完成");
   }
   
   /**
    * 读操作时捕获到异常时调用，工程出现异常的时候调用
    */
   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace();
      ctx.close();
   }
   
   @Override
   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       // System.out.println("Other  userEventTriggered");
   }
   
   @Override
   public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
       // System.out.println("Other  channelWritabilityChanged");
   }
   
	
	/**
	 * 
	 * 获取服务器时间
	 * 
	 * @return
	 */
	private String getTime() {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return time.format(System.currentTimeMillis());
	}
	
	
	public static String byteArr2StringHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		for (byte b : bytes) {
			int d = b & 0xFF;
			String v = Integer.toHexString(d).toUpperCase();
			if (v.length() == 1) {
				v = "0" + v;
			}
			buf.append(v + " ");
		}
		return buf.toString();
	}
	
	/**
	 * 计算校验和.
	 * 
	 * @param datas
	 *            接收到的字节数组
	 * @return 校验和
	 */
	public static int checkSum(byte[] datas) {
		int len = datas.length;
		int sum = 0;
		for (int i = 0; i < len - 3; i++) {
			sum += datas[i] & 0xFF;
		}
		sum = sum & 0xFF;
		return sum;
	}
	
	/**
	 * 检测接收到数据是否有效
	 * 
	 * @param datas
	 * @return
	 */
	private int check(byte[] datas) {
		int len = datas.length;
		if (len < 17) {
			logger.error("包长错误,丢弃:{}", len);
			return -1;
		}
		// 验证启动符和结束符
		if ((datas[0] & 0xFF) != '@' || (datas[1] & 0xFF) != '@' || (datas[len - 1] & 0xFF) != '#'
				|| (datas[len - 2] & 0xFF) != '#') {
			logger.error("包启动符结束符验证失败,丢弃");
			return -1;
		}

		// 校验和
		int checkSum = datas[len - 3] & 0xFF;
		int sum = checkSum(datas);
		if (checkSum != sum) {
			logger.error("校验和错误,丢弃{},{}", checkSum, sum);
			return -1;
		}
		return 1;
	}
	
	
	
	/**
	 * 解析接报文.
	 * 
	 * @param clientIp
	 *            客户端IP
	 * @param datas
	 */
	private void parse(String clientIp, byte[] datas) {
		int errorCode = 1;
		
		try {
			// 包长
			int len = datas.length;
			// 字节数组拼接成字符串
			if (len < 1024) {
				String str = byteArr2StringHex(datas);
				logger.info("解析包:{} {}", clientIp, str);
			}
			errorCode = check(datas);
			if (errorCode != 1) {
				return;
			}
			// 数据包流水号
			int pkgSN = (datas[2] & 0xFF) | ((datas[3] & 0xFF) << 8);
			// 应用数据单元长度
			int dataLen = (datas[4] & 0xFF) | ((datas[5] & 0xFF) << 8) | ((datas[6] & 0xFF) << 16)
					| ((datas[7] & 0xFF) << 24);
			if (dataLen > 100 * 1024 * 1024) {
				errorCode = -1;
				logger.error("应用数据单元长度不正确,超过限定值100*1024*1024,丢弃{}", dataLen);
				return;
			}
			if (dataLen + 12 != len) {
				errorCode = -1;
				logger.error("应用数据单元长度不正确,和数据包长不符,应用数据单元长度{},包长{},丢弃", dataLen, len);
				return;
			}
			// 命令字节
			int command = datas[8] & 0xFF;
			if (command < 1 || command > 7) {
				errorCode = -1;
				logger.error("不支持操作,丢弃,命令{}", command);
				return;
			}
			// 类型标志
			int objType = (datas[9] & 0xFF) | ((datas[10] & 0xFF) << 8);
			
			// 设备类型
			int devType = (datas[11] & 0xFF) | ((datas[12] & 0xFF) << 8);

			// 信息对象数目
			int objNum = datas[13] & 0xFF;
			if ((objNum == 0 && dataLen != 5) || (objNum > 0 && (dataLen - 5) % objNum != 0)) {
				errorCode = -1;
				logger.error("信息对象数目{}不正确,应用数据单元长度{},丢弃", objNum, dataLen);
				return;
			}
			// 信息对象
			byte[] obj = new byte[dataLen - 5];
			System.arraycopy(datas, 14, obj, 0, dataLen - 5);

//			final BaseParse parse = ParseFactory.getTcpParse(objType);
			
			logger.info("操作类型是 : {}", objType);
			if(objType == 0) {
				regist.setParams(clientIp, command, devType, obj, objNum, objType, pkgSN);
				regist.setClient(client);
				regist.run();
			} else if(objType == 3) {
				analyState.setParams(clientIp, command, devType, obj, objNum, objType, pkgSN);
				analyState.setClient(client);
				analyState.run();
				
				imgFind.setParams(clientIp, command, devType, obj, objNum, objType, pkgSN);
				imgFind.setClient(client);
				imgFind.sendSearch();
				
			} else if(objType == 4) { 
				imgFind.setParams(clientIp, command, devType, obj, objNum, objType, pkgSN);
				imgFind.setClient(client);
				imgFind.run();
			}
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
		}
	}
}
