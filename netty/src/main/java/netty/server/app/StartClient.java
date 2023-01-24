package netty.server.app;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Log4J2LoggerFactory;
import netty.client.ClientHandler;
import netty.client.RequestMessageEncoder;
import netty.client.ResponseMessageDecoder;

public class StartClient {

	public static void main(String[] args) {

		String host = "localhost";
		int port = 8080;
		EventLoopGroup workerGroup = null;
		// workerGroup asagidaki ikisiyle de olusturulabiliyor
		// java.util.concurrent.Executor
		// java.util.concurrent.ThreadFactory

		try {
			InternalLoggerFactory.setDefaultFactory(Log4J2LoggerFactory.INSTANCE);
			workerGroup = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new RequestMessageEncoder(), new ResponseMessageDecoder(),
							new ClientHandler());
				}
			});

			ChannelFuture f = bootstrap.connect(host, port).sync();

			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workerGroup != null) {
				workerGroup.shutdownGracefully();
			}
		}
	}

}
