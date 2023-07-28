package jdk;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	public static void main(String[] args) {

		try {
			DatagramPacket packet = new DatagramPacket("message".getBytes(), "message".length());
			packet.setAddress(InetAddress.getByName("localhost"));
			packet.setPort(2002);
			DatagramSocket sendSocket = new DatagramSocket();
			sendSocket.send(packet);
			System.out.println(" Sending Message to ");
			sendSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
