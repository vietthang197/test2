import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUdp {

    public static void sendUDPMessage(String message, String ipAddress, int port) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress group = InetAddress.getByName(ipAddress);
        byte[] msg = message.getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length, group, port);
        socket.send(packet);
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String s = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("receive: " + s);
        socket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        sendUDPMessage("This is a multicast messge", "230.0.0.0", 4321);
        Thread.sleep(1000);
        sendUDPMessage("This is the second multicast messge", "230.0.0.0", 4321);
        Thread.sleep(1000);
        sendUDPMessage("This is the third multicast messge", "230.0.0.0", 4321);
//		sendUDPMessage("OK", "230.0.0.0", 4321);
    }
}
