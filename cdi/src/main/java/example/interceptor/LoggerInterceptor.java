package example.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ch.qos.logback.classic.Logger;

@LogMe
@Interceptor
public class LoggerInterceptor {
	
	@Inject
	private Logger logger;

	@AroundInvoke
	private Object intercept(InvocationContext ic) throws Exception {
		logger.debug(">>> {}", ic.getMethod());
		try {
			return ic.proceed();
		}finally {
			logger.debug("<<< {}", ic.getMethod());
		}
	}

}
