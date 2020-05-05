package example.event;

import javax.enterprise.event.Observes;

public class SecurityService {

	public void userLogged(@Observes User user) {
		System.out.println("Security service receive, user:" + user.getName());
	}

}
