package example.basic;

@PassportNumber
public class PassportIdGenerator implements IdGenerator {

	public int generateId() {
		return 99999;
	}

}
