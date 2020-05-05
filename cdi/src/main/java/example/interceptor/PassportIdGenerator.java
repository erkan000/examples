package example.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import ch.qos.logback.classic.Logger;

public class PassportIdGenerator implements IdGenerator {
	
	@Inject
	private Logger logger;

	public int generateId() {
		return 999999;
	}

	@PostConstruct
	private void construct() {
		logger.debug("PassportIdGenerator before Construction");
	}
	@PreDestroy
	private void destroy() {
		logger.debug("PassportIdGenerator before Destruction");
	}

}
