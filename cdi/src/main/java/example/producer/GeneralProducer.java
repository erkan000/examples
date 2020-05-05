package example.producer;

import javax.enterprise.inject.Produces;

public class GeneralProducer {
	
	@Produces
	private int version = 42;

}
