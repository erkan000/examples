package example.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class LoggerProducer {

	@Produces
	public Logger produceLogger(InjectionPoint ip) {
		return (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(
					ip.getMember().getDeclaringClass().getName()
				);
	}

}
