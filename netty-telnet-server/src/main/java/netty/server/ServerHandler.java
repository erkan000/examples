package netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

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

		String requestData = (String) msg;
		System.out.println("GELEN:" + requestData);

		String responseData = "";
		if (requestData.contentEquals("help")) {
			responseData = "  Usage:\r\n    - help\r\n    - list\r\n    - cmd   ";
		} else {
			responseData = "You have sent command: " + requestData;
		}
		ctx.writeAndFlush(responseData + "\r\nroot>");

//		ctx.writeAndFlush(requestData + "\r\n");
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		System.err.println("IdleStateHandler triggered");
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			if (e.state() == IdleState.READER_IDLE) {
				ctx.close();
			} else if (e.state() == IdleState.WRITER_IDLE) {
				ctx.writeAndFlush("30 saniye islem yapmadiniz. 30 saniye sonra bağlantı kapatılacaktır.");
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("HATA:: " + cause.getMessage());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		System.out.println("Channel active");
		ctx.writeAndFlush("Welcome to my server\r\nroot>");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		System.out.println("Channel inactive");
	}

}
