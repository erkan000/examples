package netty.server.app;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Log4J2LoggerFactory;
import netty.server.DisconnectHandler;
import netty.server.ServerHandler;

public class StartServer {

	private final static int port = 8080;

	public static void main(String[] args) throws Exception {
		new StartServer().run();
	}

	public void run() throws Exception {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			InternalLoggerFactory.setDefaultFactory(Log4J2LoggerFactory.INSTANCE);

			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // Use NIO to accept new connections.
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(
									new IdleStateHandler(10, 5, 0),
									new DisconnectHandler(),
									new LineBasedFrameDecoder(100),
									new StringDecoder(CharsetUtil.UTF_8),
									new StringEncoder(CharsetUtil.UTF_8),
									new ServerHandler()
							);
						}

					}).option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			// Start the server.
			ChannelFuture f = b.bind(port).sync();
			System.out.println("Netty Server started.");

			// Bind and start to accept incoming connections.
			f.channel().closeFuture().sync();
		} finally {
			// Shut down all event loops to terminate all threads.
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
}
