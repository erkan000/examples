package netty.server;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import netty.model.RequestMessage;

public class RequestMessageDecoder extends ReplayingDecoder<RequestMessage> {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		RequestMessage data = new RequestMessage();
		data.setCommandId(in.readIntLE());
		int strLen = in.readInt();
		data.setStringValue("işlenmiş:" + in.readCharSequence(strLen, charset).toString());
		out.add(data);
		System.out.println("Message parsed by server");
	}
}
