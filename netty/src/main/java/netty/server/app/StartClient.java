package netty.server.app;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import netty.client.ClientHandler;
import netty.client.RequestMessageEncoder;
import netty.client.ResponseMessageDecoder;

public class StartClient {

	public static void main(String[] args) {

		String host = "localhost";
		int port = 8080;
		EventLoopGroup workerGroup = null;
		try {
			workerGroup = new NioEventLoopGroup();
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {

				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new RequestMessageEncoder(), new ResponseMessageDecoder(),
							new ClientHandler(), new LoggingHandler(LogLevel.INFO));
				}
			});

			ChannelFuture f = b.connect(host, port).sync();

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
