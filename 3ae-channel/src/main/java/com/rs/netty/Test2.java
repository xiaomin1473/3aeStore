package com.rs.netty;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test2 {
	static DatagramSocket socket = null;
	public static void a() {
		
		try {
			// 建立udp的服务 ，并且要监听一个端口。
			if (socket == null) {
				socket = new DatagramSocket(3001);
			}

			// 准备空的数据包用于存放数据。
			byte[] buf = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length); // 1024
			// 调用udp的服务接收数据
			socket.receive(datagramPacket); // receive是一个阻塞型的方法，没有接收到数据包之前会一直等待。
											// 数据实际上就是存储到了byte的自己数组中了。
			System.out.println("接收端接收到的数据：" + new String(buf, 0, datagramPacket.getLength())); // getLength()
																								// 获取数据包存储了几个字节。
			// 关闭资源
			//socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		while(true){
			a();
		}
	}
}
