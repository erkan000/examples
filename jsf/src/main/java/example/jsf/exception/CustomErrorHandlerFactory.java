package example.jsf.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;


public class CustomErrorHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory base;
    
    public CustomErrorHandlerFactory(ExceptionHandlerFactory base) {
        this.base = base;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new CustomErrorHandler(base.getExceptionHandler());
    }
    
}
