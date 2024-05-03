package examples;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestLog {

	private static final Logger logger = LogManager.getLogger(TestLog.class);

	public static void main(String[] args) {
		ThreadContext.put("id", UUID.randomUUID().toString());
		logger.info("aaa");

		new ClassWithDebugLog();
		new Thread(() -> new ClassWithDebugLog()).run();

		ThreadContext.clearAll();

	}

}
