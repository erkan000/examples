package netty.server.another;

import io.netty.buffer.ByteBuf;

public class MyMessageHeader {

	public static final int MESSAGE_HEADER_SIZE_IN_BYTES = 16;

	private int type;
	private static int number = 0;
	private int checksum;
	private int messageLength;

	public void encode(ByteBuf buf) {
		setNumber(getNumber() + 1); // number will be increased by one when new message is created
		buf.writeIntLE(type);
		buf.writeIntLE(number);
		buf.writeIntLE(checksum);
		buf.writeIntLE(messageLength);

	}

	public void decode(ByteBuf buf) {
		setType(buf.readIntLE());
		setNumber(buf.readIntLE());
		setChecksum(buf.readIntLE());
		setMessageLength(buf.readIntLE());

	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		MyMessageHeader.number = number;
	}

	public int getChecksum() {
		return checksum;
	}

	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	public int getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	public int computeAndAddChecksum(byte[] data) {
		// we need to ignore checksum part while computing checksum
		data[8] = 0;
		data[9] = 0;
		data[10] = 0;
		data[11] = 0;

		int checkSum = 0;

		for (int i = 0; i < data.length; i++) {
			checkSum += (0x000000FF & data[i]);
		}

		checkSum = (~checkSum) + 1;
		return checkSum;
	}

}
