package example.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import example.jsf.pojos.User;

@Named
@RequestScoped
public class DataTableBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7999541639972549305L;
	private List<User> users;

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
		users.add(new User(1, "Name 1", "Surname 1"));
		users.add(new User(2, "Name 2", "Surname 2"));
		users.add(new User(3, "Name 3", "Surname 3"));
		users.add(new User(4, "Name 4", "Surname 4"));
	}
	
	public void update(User user){
		User u = users.stream().filter(e -> e.getId() == user.getId()).findFirst().get();
		if(u != null) {
			u.setName(user.getName() + " modified!");
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	


}