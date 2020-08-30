package example.beans;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class LoginBean {
 
    @NotEmpty
    @Size(min = 3, message = "Password must have at least 3 characters")
    private String password;
 
    @NotEmpty
    @Size(min = 3, message = "Username must have at least 3 characters")
    private String username;
 
    @Inject
    private SecurityContext securityContext;
 
    @Inject
    private ExternalContext externalContext;
 
    @Inject
    private FacesContext facesContext;
 
    public void submit() throws IOException {    	
    	AuthenticationStatus loginResult = authenticate();
        switch (loginResult) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
                break;
            case SUCCESS:
                externalContext.redirect(externalContext.getRequestContextPath() + "/user/index.xhtml");
                break;
            case NOT_DONE:
        }
    }
 
    private AuthenticationStatus authenticate() {
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(username, password))
        );
    }
    
    public String logout() throws ServletException {
    	externalContext.invalidateSession();
    	((HttpServletRequest) externalContext.getRequest()).logout();
        return "/login.xhtml?faces-redirect=true";
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
