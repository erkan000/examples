package example.interceptor;

import javax.inject.Inject;

public class PersonService {
	
	@Inject
	private IdGenerator generator;
	
	@LogMe
	public Person createPerson(String name) {
		return new Person(name, generator.generateId());
	}

}
