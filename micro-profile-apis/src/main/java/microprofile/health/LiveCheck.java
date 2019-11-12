package microprofile.health;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class LiveCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.
                named("apis").
                up().
                withData("Health", "OK").
                withData("memory", Runtime.getRuntime().freeMemory()).
        		withData("availableProcessors", Runtime.getRuntime().availableProcessors()).
                build();
    }

}