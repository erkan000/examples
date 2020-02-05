package example.jsf;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1292315409067940127L;

	@PostConstruct
	public void init() {
		
	}
	
	public void test() {
		System.out.println("Test");
	}

}