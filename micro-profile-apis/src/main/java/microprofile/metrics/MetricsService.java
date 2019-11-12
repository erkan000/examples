package microprofile.metrics;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("metrics")
public class MetricsService {
 
	@Timed(name = "timedMethod", description = "Measure timed method execution",
            unit = MetricUnits.MILLISECONDS, absolute = true)
    @GET
    @Path("/timed")
    public String timed() {
        return "This method execution measured";
    }
	
	
	@Counted(unit = MetricUnits.NONE, name = "countedMethod", absolute = true, displayName = "hello get",
            description = "This metric counts how many hits this method received")
    @GET
    @Path("/counted")
    public String counted() {
        return "@Counted sample method";
    }
	
	
	@Metered(name = "meteredMethod", unit = MetricUnits.MILLISECONDS, 
            description = "Metered sample data", absolute = true)
    @GET
    @Path("/metered")
    public String metered() {
        return "@Metered sample method";
    }

}
