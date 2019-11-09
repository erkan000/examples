package microprofile.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("config")
public class ConfigService {

    @Inject
    @ConfigProperty(name = "variable")
    String variable;    

    @GET
    public String config() {
        return "This variable from microprofile-config.properties : " + this.variable;
    }

}
