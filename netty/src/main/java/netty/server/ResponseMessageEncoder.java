package netty.server;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import netty.model.ResponseMessage;

public class ResponseMessageEncoder extends MessageToByteEncoder<ResponseMessage> {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	protected void encode(ChannelHandlerContext ctx, ResponseMessage msg, ByteBuf out) throws Exception {
		out.writeInt(msg.getResult().length());
		out.writeCharSequence(msg.getResult(), charset);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		System.out.println("Encoder added  : " + ctx.channel().id().asLongText());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		System.out.println("Encoder removed : " + ctx.channel().id().asLongText());
	}
}
