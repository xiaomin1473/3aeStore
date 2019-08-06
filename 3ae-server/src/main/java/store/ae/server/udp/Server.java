package store.ae.server.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public void server(){
    	System.out.println("【UDP服务】已启动");
        DatagramSocket socket = null;
        try {
        	socket = new DatagramSocket(9002);
            while(true){ 
                byte[] buf = new byte[2048];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data, 0, packet.getLength());
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            socket.close();
        }
    }
    
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Server server = new Server();
                server.server();
            }
        }.start();
    }
}
