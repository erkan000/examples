package example.basic;

@NationNumber
public class NationIdGenerator implements IdGenerator {

	public int generateId() {
		return 10000;
	}

}
