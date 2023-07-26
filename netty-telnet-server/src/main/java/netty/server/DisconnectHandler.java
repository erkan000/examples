package netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DisconnectHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		System.out.println("ServerHandler2 added  : " + ctx.channel().id().asLongText());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		System.out.println("ServerHandler2 removed : " + ctx.channel().id().asLongText());
	}


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		ByteBuf data = (ByteBuf) msg;

		if (data.readableBytes() == 1 && data.getByte(0) == 3) { // 3 == CTRL+C
			System.err.println("CTRL+C pressed");
			ctx.close();
		}

		ctx.fireChannelRead(msg); // pass to chain

	}

}
