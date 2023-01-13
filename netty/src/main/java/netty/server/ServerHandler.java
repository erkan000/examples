package netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.model.RequestMessage;
import netty.model.ResponseMessage;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		System.out.println("ProcessingHandler added");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		System.out.println("ProcessingHandler removed");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		System.out.println("Request processing!");

		RequestMessage requestData = (RequestMessage) msg;
		System.out.println("GELEN:" + requestData.getCommandId() + "--" + requestData.getStringValue());

		ResponseMessage responseData = new ResponseMessage();
		responseData.setResult("You have sent command: " + requestData.getCommandId());
		ChannelFuture future = ctx.writeAndFlush(responseData);
		future.addListener(ChannelFutureListener.CLOSE);
	}
}
