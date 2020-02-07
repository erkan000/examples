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
		users.add(new User("Erkan", "Sa"));
		users.add(new User("Test 1", "Surname 1"));
		users.add(new User("Test 2", "Surname 2"));
		users.add(new User("Test 4", "Surname 4"));
	}
	
	public void test() {
		System.out.println("Test");
	}
	
	public String guncelle(User t){
		return null;
	}

	public List<User> getUsers() {
		System.out.println(users);
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	


}