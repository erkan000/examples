package example.interceptor;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class TestInterceptor {	
	
	public static void main(String[] args) {
		new TestInterceptor().test();
	}

	private void test() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();		
        PersonService service = container.select(PersonService.class).get();
		System.out.println(service.createPerson("Erkan"));
		container.shutdown();
	}

}
