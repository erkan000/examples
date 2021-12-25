package jakarta.beans;

import java.security.Principal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;

@RequestScoped
@Named
public class TestBeanSecure {

	@Inject
    SecurityContext userContext;

    private String name;
    
    public void doSomeTask() {

    	// retrieve the principal and later check whether it's null or not
        Principal callerPrincipal = userContext.getCallerPrincipal();
        
        if(callerPrincipal != null ) {
        	System.out.println("Logged in user:" + callerPrincipal.getName());
        	userContext.isCallerInRole("admin");
        }else {
        	System.out.println("User not logged in");
        }
        
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
