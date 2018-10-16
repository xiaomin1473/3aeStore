package com.rs.imgTrans;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Test6 {
	
	public void send1(){
		Socket socket = null;
		while (true) {
			try {
				socket = new Socket("192.168.0.189", 10010);
				
				byte[] arr = getFile();
				int len = arr.length;
				int t = len/1024;
				for(int i=0; i<t; i++){
					byte[] b = new byte[1024];
					System.arraycopy(arr, 1024*i, b, 0, 1024);
					socket.getOutputStream().write(b);
				}
				
				socket.getOutputStream().flush();
//				InputStream in = socket.getInputStream();
//				int len = in.available();
//				if (len > 0) {
//					byte[] b = new byte[in.available()];
//					in.read(b);
//					parse(b);
//				}
				Thread.sleep(5000);
			} catch (Exception e) {
				socket = null;
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void send() {

		Socket socket = null;
		while (true) {
			try {
				if (socket == null) {
					socket = new Socket("192.168.0.135", 10010);
					socket.getOutputStream().write(objType0());
					Thread.sleep(1000);
					socket.getOutputStream().write(get(4, 5));
					Thread.sleep(5000);
					socket.getOutputStream().write(get(1, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(2, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(3, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(5, 3));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(6, 3));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(7, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(8, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(9, 5));
					Thread.sleep(1000);
					socket.getOutputStream().write(get(10, 5));
				}
				
				InputStream in = socket.getInputStream();
				int len = in.available();
				if (len > 0) {
					byte[] b = new byte[in.available()];
					in.read(b);
					parse(b);
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				//socket = null;
				e.printStackTrace();
			}
		}
	}

	private void parse(byte[] datas) {
		int len = datas.length;
		System.out.println("datas.length=" + len);
		if (datas[0] != '@' || datas[1] != '@' || datas[len - 1] != '#' || datas[len - 2] != '#') {
			System.out.println("启动和结束符错误");
			return;
		}
		// 数据包流水号
		int pkgSN = (datas[2] & 0xFF) + (datas[3] << 8 & 0xFF);
		System.out.println("数据包流水号=" + pkgSN);
		// 应用数据单元长度
		int dataLen = (datas[4] & 0xFF) + (datas[5] << 8 & 0xFF) + (datas[6] << 16 & 0xFF) + (datas[7] << 24 & 0xFF);
		System.out.println("应用数据单元长度=" + dataLen);
		// 命令字节
		int command = datas[8] & 0xFF;
		System.out.println("命令字节=" + command);
		// 应用数据单元
		// 类型标志
		int objType = (datas[9] & 0xFF) + (datas[10] << 8 & 0xFF);
		System.out.println("类型标志=" + objType);
		// 设备类型
		int devType = (datas[11] & 0xFF) + (datas[12] << 8 & 0xFF);
		System.out.println("设备类型=" + devType);
		// 信息对象数
		int objNum = datas[13] & 0xFF;
		System.out.println("信息对象数=" + objNum);
		// 信息对象
		if (len == 17) {
			System.out.println("信息对象无");
		} else {
			System.out.println("信息对象长度=" + (len - 17));
			System.out.println("信息对象");
			for (int i = 14; i < len - 3; i++) {
				int v = datas[i] & 0xFF;
				System.out.print(v + " ");
			}
			System.out.println();
		}

		// 校验和
		int revSum = datas[len - 3] & 0xFF;
		int sum = 0;
		for (int i = 0; i < len - 3; i++) {
			sum += datas[i] & 0xFF;
		}
		sum = sum & 0xFF;
		System.out.println("接收到校验和=" + revSum + ", 计算出校验和=" + sum);
	}

	private byte[] objType0() {
		List<Byte> l = new ArrayList<Byte>();
		l.add((byte) '@');
		l.add((byte) '@');
		l.add((byte) 1);
		l.add((byte) 2);
		// 应用数据单元长度4字节
		l.add((byte) 0x91);
		l.add((byte) 0);
		l.add((byte) 0);
		l.add((byte) 0);

		l.add((byte) 7);

		l.add((byte) 0);
		l.add((byte) 0);
		l.add((byte) 1);
		l.add((byte) 0);
		l.add((byte) 1);

		l.add((byte) 2);
		l.add((byte) 0);
		l.add((byte) 18);
		l.add((byte) 9);
		l.add((byte) 10);
		l.add((byte) 8);
		l.add((byte) 0);

		l.add((byte) 1);
		l.add((byte) 2);
		l.add((byte) 18);
		l.add((byte) 8);
		l.add((byte) 9);

		for (int i = 0; i < 128; i++) {
			l.add((byte) 1);
		}

		// 校验和
		int sum = 0;
		for (int i = 0; i < l.size(); i++) {
			sum += l.get(i) & 0xFF;
		}
		sum = sum & 0xFF;
		l.add((byte) sum);

		l.add((byte) '#');
		l.add((byte) '#');

		Object[] arr = l.toArray();
		byte[] as = new byte[arr.length];
		for (int i = 0; i < arr.length; i++) {
			as[i] = (byte) arr[i];
		}

		System.out.println("as.length=" + as.length);
		return as;
	}

	private byte[] get(int objType, int command) {
		// 信息对象
		List<Byte> objs = new ArrayList<Byte>();
		if (objType == 1) {
			objs.add((byte) 1);
			objs.add((byte) 0);
			objs.add((byte) 18);
			objs.add((byte) 1);
			objs.add((byte) 2);
			objs.add((byte) 8);
			objs.add((byte) 0);
		} else if (objType == 2) {
			objs.add((byte) 1);
			objs.add((byte) 2);
			objs.add((byte) 18);
			objs.add((byte) 2);
			objs.add((byte) 3);
		} else if (objType == 3) {
			objs.add((byte) 1);
			objs.add((byte) 0);
			objs.add((byte) 0);
			objs.add((byte) 0);
		} else if (objType == 4) {
			//图片数据
			byte[] b = getFile();
			//图片数据长度4字节
			int l = b.length;
			byte[] bb = int2byteArr(l);
			for(int i=0;i<4;i++){
				objs.add(bb[i]);
			}
			objs.add((byte) 1);
			//图片数据
			for(int i=0;i<b.length;i++){
				objs.add(b[i]);
			}
		} else if (objType == 7) {
			if (command == 5) {
				objs.add((byte) 8);
				objs.add((byte) 2);
				objs.add((byte) 9);
				objs.add((byte) 1);
			}
		} else if (objType == 8) {
			objs.add((byte) 253);
			objs.add((byte) 128);
			objs.add((byte) 168);
			objs.add((byte) 192);
		} else if (objType == 9) {
			if (command == 5) {
				objs.add((byte) 8);
			}
		} else if (objType == 10) {
			if (command == 5) {
				objs.add((byte) 8);
				objs.add((byte) 7);
			}
		}

		List<Byte> l = new ArrayList<Byte>();
		l.add((byte) '@');
		l.add((byte) '@');
		// 数据包流水号
		l.add((byte) 2);
		l.add((byte) 22);
		// 应用数据单元长度4字节
		int dataLen = objs.size() + 5;
		byte[] arr = int2byteArr(dataLen);
		l.add(arr[0]);
		l.add(arr[1]);
		l.add(arr[2]);
		l.add(arr[3]);

		// 命令字节
		l.add((byte) command);
		// 应用数据单元
		// 类型标志
		l.add((byte) objType);
		l.add((byte) 0);
		// 设备类型
		l.add((byte) 2);
		l.add((byte) 0);
		// 信息对象数
		l.add((byte) 1);
		// 信息对象
		l.addAll(objs);

		// 校验和
		int sum = 0;
		for (int i = 0; i < l.size(); i++) {
			sum += l.get(i) & 0xFF;
		}
		l.add((byte) (sum & 0xFF));

		l.add((byte) '#');
		l.add((byte) '#');

		byte[] b = new byte[l.size()];
		for (int i = 0; i < l.size(); i++) {
			b[i] = l.get(i);
		}

		return b;
	}

	private byte[] int2byteArr(int src) {
		byte[] arr = new byte[4];
		arr[3] = (byte) (src >> 24);
		arr[2] = (byte) (src >> 16);
		arr[1] = (byte) (src >> 8);
		arr[0] = (byte) src;

		return arr;
	}
	
	private static byte[] getFile(){
		String path = "E:/frame.yuv";
		try{
			FileInputStream in = new FileInputStream(path);
			byte[] b = new byte[in.available()];
			in.read(b);
//			for(int i=0;i<b.length;i++){
//				System.out.print(Integer.toHexString((b[i]&0xFF))+" ");
//				if(i%10==0){
//					System.out.println();
//				}
//			}
			in.close();
			return b;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getFile().length);
		new Test6().send();
	}
}
