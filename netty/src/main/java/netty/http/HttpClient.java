package netty.http;

import java.util.HashMap;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AttributeKey;

public class HttpClient {
	
	private static String host = "192.168.2.11";
	private static int port = 8081;
	private static boolean isPipeRaw = true;
	public static final AttributeKey<HashMap<String, String>> MAP_KEY = AttributeKey.valueOf("path_mapping");

	public static void main(String[] args) {

		EventLoopGroup workerGroup = null;
		try {
			workerGroup = new NioEventLoopGroup();
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline p = ch.pipeline();
					p.addLast(new HttpClientCodec());
					if (isPipeRaw) {
						p.addLast(new RawHttpClientHandler());
					} else {
						p.addLast(new HttpObjectAggregator(10000));
						p.addLast(new WrappedHttpClientHandler());
					}
					ch.attr(MAP_KEY).set(new HashMap<String, String>());
				}
			});

			// connectAndSend(bootstrap, "/receivers");
			// connectAndSend(bootstrap, "/cit/report?uuid=puhu-abcd-2");

			connectAndSend(bootstrap, "/nexus/#view-repositories;ehkks-releases~browsestorage");
			for (int i = 0; i < 100; i++) {
				Thread.sleep(50);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workerGroup != null) {
				workerGroup.shutdownGracefully();
			}
		}
	}

	private static void connectAndSend(Bootstrap bootstrap, String path) throws InterruptedException {
		ChannelFuture connectFuture = bootstrap.connect(host, port).sync();

		// Wait until the connection is made successfully.
		Channel channel = connectFuture.sync().channel();

		makeRequest(channel, path);

		// Wait until the connection is closed or the connection attempt fails.
		// connectFuture.channel().closeFuture().sync();
	}

	private static void makeRequest(Channel ch, String path) {
		HttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, path,
				Unpooled.EMPTY_BUFFER);
		request.headers().set(HttpHeaderNames.HOST, host);
		request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
		request.headers().set(HttpHeaderNames.USER_AGENT, "Java");
		request.headers().set(HttpHeaderNames.ACCEPT, HttpHeaderValues.APPLICATION_JSON);

		HashMap<String, String> packetMap = ch.attr(HttpClient.MAP_KEY).get();
		packetMap.put(ch.id().asLongText(), path);
		
		ch.writeAndFlush(request);
		
	}

}
