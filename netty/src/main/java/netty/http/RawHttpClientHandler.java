package netty.http;

import java.util.HashMap;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

public class RawHttpClientHandler extends SimpleChannelInboundHandler<HttpObject> {

	@Override
	public void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {

		HashMap<String, String> packetMap = ctx.channel().attr(HttpClient.MAP_KEY).get();

		System.out.println("*** Message Type *** : " + msg);

		System.out.println(packetMap);

		if (msg instanceof HttpResponse) {
			HttpResponse response = (HttpResponse) msg;
			printHeaders(response);
			printResponseStatus(response);
		}

		if (msg instanceof HttpContent) {
			HttpContent content = (HttpContent) msg;

			String key = ctx.channel().id().asLongText();

			System.out.println(packetMap.get(key) + "::"
					+ content.content().toString(CharsetUtil.UTF_8));

			if (msg instanceof LastHttpContent) {
				System.out.println(content);
				ctx.close();
				packetMap.remove(ctx.channel().id().asLongText());
			}
		}

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

	private void printResponseStatus(HttpResponse response) {
		System.err.println("STATUS: " + response.status());
		System.err.println("VERSION: " + response.protocolVersion());
		System.err.println();

		if (HttpUtil.isTransferEncodingChunked(response)) {
			System.err.println("--- CHUNKED CONTENT ---");
		} else {
			System.err.println("--- CONTENT ---");
		}
	}

	private void printHeaders(HttpMessage response) {
		if (!response.headers().isEmpty()) {
			for (CharSequence name : response.headers().names()) {
				for (CharSequence value : response.headers().getAll(name)) {
					System.err.println("Header: " + name + " = " + value);
				}
			}
		}
	}

}
