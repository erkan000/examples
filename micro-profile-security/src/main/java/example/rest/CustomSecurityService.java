package example.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import example.enums.Roles;

import java.security.Principal;
import java.util.StringJoiner;

@ApplicationScoped
class CustomSecurityService {

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @Inject
    private SecurityContext securityContext;

    public String validateUser() {
    	StringJoiner roles = new StringJoiner(",");
        final Principal principal = securityContext.getCallerPrincipal();
        if (principal == null) {
            return "Auth bilgisi yok";
        }else {
        	if(securityContext.isCallerInRole(Roles.USER.get())) {
        		roles.add("User");
        	}
        	if(securityContext.isCallerInRole(Roles.ADMIN.get())) {
        		roles.add("Admin");
        	}
        }
        
        passwordHash.generate(roles.toString().toCharArray());

        return roles.toString();
    }

}
