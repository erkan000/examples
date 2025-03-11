package examples.java;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
    
    // Pointcut that matches all methods in UserService
    @Pointcut("execution(* examples.java.UserService.*(..))")
    public void userServiceMethods() {}
    
    // Before advice - runs before the method execution
    @Before("userServiceMethods()")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        System.out.println("\n[Aspect] Before executing: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            System.out.println("[Aspect] Method arguments: " + args[0]);
        }
    }
    
    // After returning advice - runs after successful method execution
    @AfterReturning(pointcut = "execution(* examples.java.UserService.getUser(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[Aspect] Method returned: " + result);
    }
    
    // After throwing advice - runs if method throws an exception
    @AfterThrowing(pointcut = "userServiceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("[Aspect] Exception in " + joinPoint.getSignature().getName() 
                          + ": " + error.getMessage());
    }
    
    // After advice - runs after method execution (regardless of success or failure)
    @After("userServiceMethods()")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("[Aspect] Finished executing: " + joinPoint.getSignature().getName());
    }
} 