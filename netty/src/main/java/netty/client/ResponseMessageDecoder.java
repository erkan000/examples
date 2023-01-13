package netty.client;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import netty.model.ResponseMessage;

public class ResponseMessageDecoder extends ReplayingDecoder<ResponseMessage> {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		System.out.println("Message decoding");
		ResponseMessage data = new ResponseMessage();
		int strLen = in.readInt();
		data.setResult(in.readCharSequence(strLen, charset).toString());
		out.add(data);

	}
}
