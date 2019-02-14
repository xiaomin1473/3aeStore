package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String info = null;
				while((info = br.readLine()) != null) {
					System.out.println(info);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
