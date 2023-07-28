package netty.server.another;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.DatagramPacketDecoder;
import io.netty.handler.logging.LoggingHandler;

public class UdpServerAbstractImpl extends UdpServerAbstract<MyMessage> {

	private final static int port = 6671;

	public static void main(String[] args) throws Exception {
		new UdpServerAbstractImpl().run();
	}

	public void run() throws Exception {

		connect(6671);

		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2,
				runnable -> new Thread(runnable, "UdpServerImpl Thread"));

		executorService.scheduleAtFixedRate(() -> {

			MyStatusMessage message = new MyStatusMessage();
			message.setBatteryLevel(10);
			message.setCommChannelNo(50);
			write(message);
		}, 0, 4,
				TimeUnit.SECONDS);

	}

	@Override
	protected void addHandlersToPipeline(NioDatagramChannel ch) {
		ch.pipeline().addLast("OrfozMessageDecoder", new DatagramPacketDecoder(new MyMessageDecoder()));
		InetSocketAddress inetMsg = new InetSocketAddress("localhost", port + 1);
		ch.pipeline().addLast("OrfozMessageEncoder", new MyMessageEncoder(inetMsg));
		ch.pipeline().addLast("OrfozChannelHandler", new ServerHandler());
		ch.pipeline().addLast("LoggingHandler", new LoggingHandler());

	}
}
