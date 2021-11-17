package utils;

public class GenericMessage<E> {
	
	private String key;
	private E instance;
	
	public GenericMessage(String key, E e) {
		this.key = key;
		instance = e;
	}
	
	public E get() {
		return instance;
	}
	
	public String getKey() {
		return key;
	}
}
