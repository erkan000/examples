package example.websocket.handlers;

public class Message {
	
	private String name;
	private int number;
	
	@Override
	public String toString() {
		return name + "-" + number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
