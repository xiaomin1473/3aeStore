package com.ae.service.user;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(80,1,InetAddress.getByName("127.0.0.1"));
		while(true) {
			try {
				System.out.println("*** 服务器即将启动，请耐心等待 ***");
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String info = null;
				while((info = br.readLine()) != null) {
					System.out.println("我是服务器，客户端说：" + info);
					if(info.trim().equals("")) {
						String head ="HTTP/1.1 200 OK\r\n" +
								"Accept-Ranges: bytes\r\n" +
								"Content-Length: 75\r\n" +
								"Content-Type: text/html\r\n" +
								"Date: Tue, 21 Aug 2018 08:18:51 GMT\r\n" +
								"Last-Modified: Tue, 21 Aug 2018 08:17:47 GMT\r\n"+
								"\r\n";
						//tomcat在读取index.html
						String html= "<html><head><title>test</title></head><body><h1>aacccffffdaa</h1></body></html>";

						html=head+html;
						out.write(html.getBytes());
						out.flush();

						System.out.println("aaaaaaaaaaaaaaaa");
//						socket.close();
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
