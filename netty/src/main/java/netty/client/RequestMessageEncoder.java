package netty.client;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import netty.model.RequestMessage;

public class RequestMessageEncoder extends MessageToByteEncoder<RequestMessage> {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	protected void encode(ChannelHandlerContext ctx, RequestMessage msg, ByteBuf out) throws Exception {

		System.out.println("Message encoded for sending");
		out.writeIntLE(msg.getCommandId());
		out.writeInt(msg.getStringValue().length());
		System.out.println(msg.getStringValue().length());
		out.writeCharSequence(msg.getStringValue(), charset);

	}
}
