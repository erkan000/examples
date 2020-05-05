package example.basic;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class TestBasic {	
	
	public static void main(String[] args) {
		new TestBasic().test();
	}

	private void test() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();		
        PersonService service = container.select(PersonService.class).get();
		System.out.println(service.createPerson("Erkan"));
		System.out.println(service.createPersonNation("Nurdan"));
		container.shutdown();
	}

}
