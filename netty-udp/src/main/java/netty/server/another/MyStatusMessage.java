package netty.server.another;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;


public class MyStatusMessage extends MyMessage {

	private int commChannelNo;
	private int batteryLevel;

	public MyStatusMessage() {
		orfozMessageHeader = new MyMessageHeader();
	}

	public MyStatusMessage(MyMessageHeader orfozMessageHeader) {
		this.orfozMessageHeader = orfozMessageHeader;
	}

	@Override
	public int computeMessageLength() {
		return 16;
	}

	@Override
	public void encode(ByteBuf buf) {
		orfozMessageHeader.setType(1);
		orfozMessageHeader.setMessageLength(computeMessageLength());
		orfozMessageHeader.encode(buf);

		String bitString = "";

		bitString += getBits((byte) batteryLevel, 1);

		buf.writeByte((byte) Integer.parseInt(bitString, 2));
		bitString = "";

		bitString += getBits((byte) commChannelNo, 1);
		buf.writeByte((byte) Integer.parseInt(bitString, 2));
		bitString = "";

		orfozMessageHeader.setChecksum(orfozMessageHeader.computeAndAddChecksum(ByteBufUtil.getBytes(buf)));
		buf.setIntLE(8, orfozMessageHeader.getChecksum());
	}

	@Override
	public void decode(ByteBuf buf) {
		setBatteryLevel(buf.readByte());

		setCommChannelNo(buf.readByte());
		buf.readByte();
		buf.readByte();
		buf.readByte();
	}



	public int getCommChannelNo() {
		return commChannelNo;
	}

	public void setCommChannelNo(int commChannelNo) {
		this.commChannelNo = commChannelNo;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}


	private String getBits(byte value, int length) {
		String bits = toBitString(value);
		return bits.substring(bits.length() - length, bits.length());
	}

	public String toBitString(final byte val) {
		return String.format("%8s", Integer.toBinaryString(val & 0xFF)).replace(' ', '0');
	}



}
