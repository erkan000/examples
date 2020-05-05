package example.event;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class TestEvent {	
	
	public static void main(String[] args) {
		new TestEvent().test();
	}

	private void test() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();		
        UserService service = container.select(UserService.class).get();
		service.userLoggedIn("Erkan");
		container.shutdown();
	}

}
