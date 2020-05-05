package example.event;

import javax.enterprise.event.Observes;

public class FrontEndService {

	public void userLogged(@Observes User user) {
		System.out.println("Frontend service receive, user:" + user.getName());
	}

}
