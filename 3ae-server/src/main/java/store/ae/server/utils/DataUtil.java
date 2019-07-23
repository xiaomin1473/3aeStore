package store.ae.server.utils;

import store.ae.server.common.Constants;
import store.ae.server.common.ErrorCode;

public class DataUtil {

	/**
	 * 私有构造函数.
	 */
	private DataUtil() {

	}

	/**
	 * 字节数组转整型,低字节在前.
	 * 
	 * @param arr
	 *            字节数组
	 * @return 整型
	 */
	public static int byteArr2int(byte[] arr) {
		int v = 0;
		for (int i = 0; i < arr.length; i++) {
			v |= ((arr[i] & 0xFF) << i * 8);
		}
		if (arr.length == 2) {
			v = (short) v;
		}
		return v;
	}

	/**
	 * 字节数组拼接成十六字符串.
	 * 
	 * @param bytes
	 *            字节数组
	 * @return 拼接后的字符串
	 */
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
	 * bool数组拼接成十进制字符串.
	 * 
	 * @param bools
	 *            bool数组
	 * @return 拼接后的字符串
	 */
	public static String boolArr2StringDec(boolean[] bools) {
		StringBuffer buf = new StringBuffer();
		for (boolean b : bools) {
			buf.append((b ? 1 : 0) + " ");
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
	 * 获取命令字符串
	 * 
	 * @param command
	 *            命令
	 * @return 字符串
	 */
	public static String getCommand(int command) {
		String str = command + "";
		switch (command) {
		case Constants.Command.CMD_1:
			str = "控制/设置";
			break;
		case Constants.Command.CMD_2:
			str = "上传";
			break;
		case Constants.Command.CMD_3:
			str = "确认";
			break;
		case Constants.Command.CMD_4:
			str = "查询";
			break;
		case Constants.Command.CMD_5:
			str = "应答";
			break;
		case Constants.Command.CMD_6:
			str = "否认";
			break;
		case Constants.Command.CMD_7:
			str = "注册";
			break;
		case Constants.Command.CMD_8:
			str = "初始化";
			break;
		default:
			break;
		}
		return str;
	}

	/**
	 * 获取整型位对应的数值.
	 * 
	 * @param value
	 *            整型
	 * @param bit
	 *            要获取获取位
	 * @return 位转成的数值
	 */
	public static int getBit(int value, int bit) {
		return value >> bit & 0x0001;
	}

	/**
	 * 获取错误信息
	 * 
	 * @param error
	 *            错误码
	 * @return 错误信息
	 */
	public static String getErrorInfo(int error) {
		String errorInfo = "其他错误";
		switch (error) {
		case ErrorCode.PKG.SUCCESS:
			errorInfo = "正常";
			break;
		case ErrorCode.PKG.CHECK:
			errorInfo = "校验和错误";
			break;
		case ErrorCode.PKG.COMMANDNOTSUPPORT:
			errorInfo = "不支持操作";
			break;
		case ErrorCode.PKG.EXCUTE:
			errorInfo = "执行错误";
			break;
		case ErrorCode.PKG.RECEIVEBUSY:
			errorInfo = "接收方忙";
			break;
		case ErrorCode.PKG.DATALENGTH:
			errorInfo = "应用数据单元长度不正确";
			break;
		case ErrorCode.PKG.OBJNUM:
			errorInfo = "信息对象数目不正确";
			break;
		case ErrorCode.PKG.DEVTYPE:
			errorInfo = "设备类型不正确";
			break;
		case ErrorCode.PKG.OBJINVALID:
			errorInfo = "信息对象数据无效";
			break;
		case ErrorCode.PKG.DEV_IDLE:
			errorInfo = "设备不在线";
			break;
		case ErrorCode.PKG.TIMEOUT:
			errorInfo = "超时";
			break;
		default:
			break;
		}
		return errorInfo;
	}

	/**
	 * 按字节数取正数最大值
	 * 
	 * @param size
	 *            字节数 最大7个字节
	 * @return 最大值
	 */
	public static long getMax(int size) {
		long v = (2l << (size * 8 - 1)) - 1;
		return v;
	}

	/**
	 * 通过设备类型获取设备类别
	 * 
	 * @param devType
	 *            设备类型
	 * @return 设备类别 1:主设备 2:开关量子设备 3:CAN主机子设备 4:末端试水主机子设备
	 */
	public static int getDevKind(int devType) {
		// 服务器
		if (devType == Constants.Server.DEVTYPE) {
			return 0;
		}
		if (devType < 100) {
			// 主设备
			return Constants.DevKind.KIND_1;
		} else if (devType < 200) {
			// 开关量子设备
			return Constants.DevKind.KIND_2;
		} else if (devType < 300) {
			// CAN主机子设备
			return Constants.DevKind.KIND_3;
		} else if (devType < 400) {
			// 末端试水主机子设备
			return Constants.DevKind.KIND_4;
		}
		// 感温光纤区域
		return Constants.DevKind.KIND_5;
	}

	/**
	 * 整型转字节数组,低字节在前.
	 * 
	 * @param src
	 *            整型
	 * @param len
	 *            字节数组长度
	 * @return 字节数组
	 */
	public static byte[] int2byteArr(int src, int len) {
		byte[] arr = new byte[len];
		for (int i = len - 1; i >= 0; i--) {
			arr[i] = (byte) (src >> i * 8);
		}
		return arr;
	}

	/**
	 * 整型数组转字节数组
	 * 
	 * @param value
	 *            整型数组内容如:[1,1,1,1,1,1,1,1]
	 * @return 转后字节数组
	 */
	public static byte[] intArr2byteArr(int[] value) {
		String b = "";
		for (int i = 0; i < value.length; i++) {
			b = value[i] + b;
		}
		return DataUtil.int2byteArr(Integer.parseInt(b, 2), value.length / 8);
	}

	/**
	 * 字节数组翻转
	 * 
	 * @param bytes
	 *            原字节数组
	 * @return 翻转后字节数组
	 */
	public static byte[] reverse(byte[] bytes) {
		int len = bytes.length;
		byte[] data = new byte[len];
		for (int i = 0; i < len; i++) {
			data[i] = bytes[len - i - 1];
		}
		return data;
	}

	/**
	 * 短整型数组拼接成字符串.
	 * 
	 * @param data
	 *            短整型数组
	 * @return 拼接后的字符串
	 */
	public static String shortArr2String(short[] data) {
		StringBuffer buf = new StringBuffer();
		for (short b : data) {
			buf.append(b + " ");
		}
		return buf.toString();
	}

	/**
	 * 整型转字符串
	 * 
	 * @param value
	 *            整型值
	 * @param len
	 *            需要转的字符串长度
	 * @return 转后字符串
	 */
	public static String toString(int value, int len) {
		String str = value + "";
		len = len - str.length();
		for (int i = 0; i < len; i++) {
			str = "0" + str;
		}
		return str;
	}
}
