package example.basic;

import javax.inject.Inject;

public class PersonService {
	
	@Inject
	@PassportNumber
	private IdGenerator generator;
	
	public Person createPerson(String name) {
		return new Person(name, generator.generateId());
	}
	
	@Inject
	@NationNumber
	private IdGenerator generatorNation;
	
	public Person createPersonNation(String name) {
		return new Person(name, generatorNation.generateId());
	}

}
