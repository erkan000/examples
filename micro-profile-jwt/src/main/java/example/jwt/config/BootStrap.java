package example.jwt.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod = "MP-JWT", realmName = "")
@ApplicationPath("jwt")
public class BootStrap extends Application {
}
