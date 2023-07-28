package jdk;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {

	public static void main(String[] args) {

		while (true) {
			try {
				// Receive some bytes
				byte[] buffer = new byte[256]; // max length 256
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				int listenPort = 2002;
				DatagramSocket socket = new DatagramSocket(listenPort);
				if (socket != null) {
					socket.receive(packet);
					System.out.println(buffer.length);
					socket.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
