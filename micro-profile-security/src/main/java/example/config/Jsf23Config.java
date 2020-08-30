package example.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

@ApplicationScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@CustomFormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(loginPage = "/login.xhtml",
											errorPage = "/login.xhtml"
		))
@ServletSecurity(
		value = @HttpConstraint(rolesAllowed = { "user", "admin" },
		transportGuarantee = ServletSecurity.TransportGuarantee.NONE
		))
public class Jsf23Config {
	// @ApplicationScoped daki değişiklikler sunucuyu restart gerektirir!
}
