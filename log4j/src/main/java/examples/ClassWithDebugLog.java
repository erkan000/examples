package examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassWithDebugLog {

	private static final Logger logger = LogManager.getLogger(ClassWithDebugLog.class);

	public ClassWithDebugLog() {
		logger.debug("Debug message");
	}

}
