package netty.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class StartServer {

	private final static int port = 1111;

	public static void main(String[] args) throws Exception {
		new StartServer().run();
	}

	public void run() throws Exception {

		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			// InternalLoggerFactory.setDefaultFactory(Log4J2LoggerFactory.INSTANCE);

			Bootstrap b = new Bootstrap();
			b.group(workerGroup).channel(NioDatagramChannel.class)

					.handler(new ChannelInitializer<NioDatagramChannel>() {

						@Override
						public void initChannel(NioDatagramChannel ch) throws Exception {
							ch.pipeline().addLast(new ServerHandler());
						}

					});
			b.option(ChannelOption.SO_BROADCAST, true);
			b.option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(40960)); // UDP default 2048 byte
																							// alıyor, gerisi çöpe
																							// gidiyor. Bunu arttırma																				// için bu satır

			// Start the server.
			ChannelFuture f = b.bind(port).sync();
			System.out.println("Netty Server started.");

			// Bind and start to accept incoming connections.
			f.channel().closeFuture().sync();
		} finally {
			// Shut down all event loops to terminate all threads.
			workerGroup.shutdownGracefully();
		}
	}
}
