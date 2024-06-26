package jakarta.controllers;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(PersonController.class);
	}
}
