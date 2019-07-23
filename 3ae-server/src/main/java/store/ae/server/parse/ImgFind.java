package store.ae.server.parse;

import java.io.FileOutputStream;

import store.ae.server.common.Constants;
import store.ae.server.common.ErrorCode;
import store.ae.server.utils.ConvertImage;

public class ImgFind extends BaseParse{
	
	@SuppressWarnings("unused")
	public void sendSearch() throws Exception {
		
		String request =  "40 40 00 00 05 00 00 00 04 04 00 01 00 01 ^^ 23 23";
		String Srequest = "40 40 5B 00 05 00 00 00 04 04 00 01 00 00 E9 23 23";
		
		sendVoid(devIp, pkgSN, Constants.Command.CMD_4, 4, devType, null);
	}
	
	public int run() {
		
		
		System.out.println("\n【设备消息】  \n 数据长度：" + obj.length);
		try {
			// 命令上传/确认 查询/应答
			if (command != Constants.Command.CMD_2 && command != Constants.Command.CMD_5) {
				logger.error("不支持操作,消防设施报警图片,命令错误{},丢弃", command);
				return ErrorCode.PKG.COMMANDNOTSUPPORT;
			}
			// 图片数据长度
			int picLen = (obj[0] & 0xFF) | ((obj[1] & 0xFF) << 8) | ((obj[2] & 0xFF) << 16) | ((obj[3] & 0xFF) << 24);
			if (obj.length != 5 + picLen) {
				logger.error("信息对象数据无效,消防设施报警图片,信息对象长度错误{},丢弃", obj.length);
				return ErrorCode.PKG.OBJINVALID;
			}
			logger.info("消防设施报警图片");
			// 信息对象
			// 图片格式
			// int v = obj[4] & 0xFF;
			if (command == Constants.Command.CMD_2) {
				// 上传命令需要回复确认
				sendVoid(devIp, pkgSN, Constants.Command.CMD_3, 4, devType, null);
			} else {
				// 图片
				String img = pkgSN +"";
				byte[] pic = new byte[picLen];
				System.arraycopy(obj, 5, pic, 0, picLen);
				toFileYUV(pic, img);
				toFileRGB(pic, img);
			}
			return ErrorCode.PKG.SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ErrorCode.PKG.IGNORE;
		}
	}
	
	
	
	private void toFileRGB(byte[] b, String img) {
		try {
			String desPath = "D:/" + img + ".jpg";
			if (devType == Constants.DevType.TYPE_1) {
				ConvertImage.yuv420SPToRGB(b, 720, 576, desPath);
			} else if (devType == Constants.DevType.TYPE_2) {
				ConvertImage.yuv422SPToRGB(b, 720, 576, desPath);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private void toFileYUV(byte[] b, String img) {
		FileOutputStream os = null;
		try {
			String path = "D:/" + img + ".yuv";
			os = new FileOutputStream(path);
			os.write(b);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
}
