package netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.model.RequestMessage;
import netty.model.ResponseMessage;

public class ClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Connected, channel ready to send");
		RequestMessage msg = new RequestMessage();
		msg.setCommandId(0xAABBCCDD);
//		msg.setCommandId(180079837);
		msg.setStringValue("hello netty");
		ctx.writeAndFlush(msg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Message arrived");
		ResponseMessage message = (ResponseMessage) msg;
		System.out.println("Server responded: " + message.getResult());
		ctx.close();
	}

}
