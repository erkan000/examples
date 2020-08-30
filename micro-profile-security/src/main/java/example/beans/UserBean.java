package example.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.StringJoiner;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

import example.enums.Roles;

@Named
@RequestScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SecurityContext securityContext;
    
    @Inject
	private ExternalContext externalContext;

    public String getUsername() throws IOException {
    	String loggedInUSER = "";
    	if(securityContext.getCallerPrincipal() == null) {
    		externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
    	}else {
    		loggedInUSER = securityContext.getCallerPrincipal().getName();
    	}
    	return loggedInUSER;
    }

    public String getRoles() {
        StringJoiner roles = new StringJoiner(",");
        if (securityContext.isCallerInRole(Roles.ADMIN.get())) {
            roles.add(Roles.ADMIN.get());
        }
        if (securityContext.isCallerInRole(Roles.USER.get())) {
        	roles.add(Roles.USER.get());
        }
        return roles.toString();
    }

}
