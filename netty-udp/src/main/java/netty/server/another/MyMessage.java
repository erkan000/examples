package netty.server.another;

import io.netty.buffer.ByteBuf;

public abstract class MyMessage {

	protected MyMessageHeader orfozMessageHeader;

	public abstract void encode(ByteBuf buf);

	public abstract void decode(ByteBuf buf);

	public abstract int computeMessageLength();

	public MyMessage() {
		orfozMessageHeader = new MyMessageHeader();
	}

	public MyMessage(MyMessageHeader orfozMessageHeader) {
		this.orfozMessageHeader = orfozMessageHeader;
	}

	public MyMessageHeader getOrfozMessageHeader() {
		return orfozMessageHeader;
	}

	public void setOrfozMessageHeader(MyMessageHeader orfozMessageHeader) {
		this.orfozMessageHeader = orfozMessageHeader;
	}

}
