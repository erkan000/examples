package example.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import example.jsf.pojos.User;

@Named
@RequestScoped
public class AjaxBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6081837191119929139L;
	private List<User> users;
	private User selectedUser;
	private double aNumber;
	private String event;
	private double aValue;

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
		users.add(new User(1, "Name 1", "Surname 1"));
		users.add(new User(2, "Name 2", "Surname 2"));
		users.add(new User(3, "Name 3", "Surname 3"));
		users.add(new User(4, "Name 4", "Surname 4"));
	}

	public void changeWithAjax(AjaxBehaviorEvent e){
		Integer userID = Integer.parseInt(((UIInput)e.getComponent()).getValue().toString());
		User u = users.stream().filter(ue -> ue.getId() == userID).findFirst().get();
		setSelectedUser(u);
	}
	
	public void onFocus(AjaxBehaviorEvent e){
	    setEvent("Focus Event !");	
	}
	
	public void onKeyup(AjaxBehaviorEvent e){
	    setEvent("Keyup Event !");	
	}
	
	public void rasgeleSayiUret(){	
		aNumber = Math.random() + aValue;		
	}
	public double getaNumber() {
		return aNumber;
	}

	public void setaNumber(double aNumber) {
		this.aNumber = aNumber;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public double getaValue() {
		return aValue;
	}

	public void setaValue(double aValue) {
		this.aValue = aValue;
	}
	
	
		

}