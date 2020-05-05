package example.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class UserService {
	
	@Inject
	private Event<User> userEvent;
	
	public void userLoggedIn(String name) {
		User user = new User();
		user.setName(name);
		userEvent.fire(user);
		System.out.println("All events succesfully fired!");
	}

}
