package example.jsf;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import example.jsf.pojos.User;

@Named
@RequestScoped
public class Bean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1292315409067940127L;
	private int intValue = 12;
	private String stringValue;
	private long longValue;
	private User selectedUser;
	
	public void test() {
		System.out.println("Test");
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public long getLongValue() {
		return longValue;
	}

	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}


}