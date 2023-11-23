package netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.util.CharsetUtil;

public class WrappedHttpClientHandler extends SimpleChannelInboundHandler<FullHttpMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpMessage msg) throws Exception {

		System.out.println(msg.content().toString(CharsetUtil.UTF_8));

	}

}
