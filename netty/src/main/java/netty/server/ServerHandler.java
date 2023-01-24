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
		System.out.println("ServerHandler added  : " + ctx.channel().id().asLongText());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		System.out.println("ServerHandler removed : " + ctx.channel().id().asLongText());
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
