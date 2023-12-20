package netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.DatagramPacket;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		DatagramPacket in = ((DatagramPacket) msg);

		ByteBuf byteBuf = in.content();

//		System.out.println("Message arrived to server: " + byteBuf.readableBytes());

		byte mesajKodu = byteBuf.readByte();
		byte mesajNo = byteBuf.readByte();
		int paketSayisi = byteBuf.readUnsignedShortLE();
		int paketNo = byteBuf.readUnsignedShortLE();
		int paketBoyu = byteBuf.readUnsignedShortLE();
		int veriBoyutu = byteBuf.readUnsignedShortLE();

		int kalanByteUzunlugu = byteBuf.readableBytes();

		System.out.println(mesajKodu + "-" + mesajNo + "-" + paketSayisi + "-" + paketNo + "-" + paketBoyu + "-"
				+ veriBoyutu + " - " + kalanByteUzunlugu);

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
