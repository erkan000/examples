package example.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -4793015958569150435L;
	private String username;
    private String password;
 
    public String execute() {
    	
        if (this.username.equals("admin") && this.password.equals("admin")) {
            return "success";
        } else {
            return "error";
        }
        
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}