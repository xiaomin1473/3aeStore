package store.ae.server.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void send(){        
        try {
            DatagramSocket socket = new DatagramSocket();
            String text = "test";
            byte[] buf = text.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 9002);
            socket.send(packet);
            socket.close();
        } catch (Exception e) {            
            e.printStackTrace();
            
        }
    }
    public static void main(String[] args) {
        send();
    }
}
