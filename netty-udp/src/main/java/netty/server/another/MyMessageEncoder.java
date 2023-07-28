package netty.server.another;

import java.net.InetSocketAddress;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;

public class MyMessageEncoder extends MessageToMessageEncoder<MyMessage> {

	private InetSocketAddress socketAddress;

	public MyMessageEncoder(InetSocketAddress socketAddress) {
		this.socketAddress = socketAddress;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, MyMessage msg, List<Object> out) throws Exception {
		ByteBuf buf = Unpooled.buffer();
		msg.encode(buf);
		out.add(new DatagramPacket(buf, socketAddress));
	}

}
