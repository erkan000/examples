package netty.server;

import java.nio.charset.Charset;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.DatagramPacket;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		DatagramPacket in = ((DatagramPacket) msg);

		String veri = in.content().readCharSequence(in.content().readableBytes(), charset).toString();
		System.out.println("Message arrived to server: " + veri);
		// ChannelFuture future = ctx.writeAndFlush("");

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println(cause.getMessage());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		System.out.println("Channel active");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		System.out.println("Channel inactive");
	}

}
