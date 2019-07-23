package store.ae.server.udp;

import java.net.DatagramSocket;
import java.net.InetAddress;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.DatagramPacket;

public class LocalUDPDataReciever
{
        private static final String TAG = LocalUDPDataReciever.class.getSimpleName();
        private static LocalUDPDataReciever instance = null;
        private Thread thread = null;
 
        public static LocalUDPDataReciever getInstance()
        {
                if (instance == null)
                        instance = new LocalUDPDataReciever();
                return instance;
        }
 
        public void startup()
        {
                this.thread = new Thread(new Runnable()
                {
                        public void run()
                        {
                                try
                                {
 
                                        //开始侦听
                                        LocalUDPDataReciever.this.udpListeningImpl();
                                }
                                catch (Exception eee)
                                {
                                        
                                }
                        }
                });
                this.thread.start();
        }
 
        private void udpListeningImpl() throws Exception
        {
                while (true)
                {
                        //ByteBuf data = new byte[1024];
                        // 接收数据报的包
                        //DatagramPacket packet = new DatagramPacket(data, null);
 
                        DatagramSocket localUDPSocket = LocalUDPSocketProvider.getInstance().getLocalUDPSocket();
                        if ((localUDPSocket == null) || (localUDPSocket.isClosed()))
                                continue;
                         
                        // 阻塞直到收到数据
                        //localUDPSocket.receive(packet);
                         
                        // 解析服务端发过来的数据
                        //String pFromServer = new String(packet.getData(), 0 , packet.getLength(), "UTF-8");
                        }
        }
}
