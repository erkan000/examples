package listener;

import javax.batch.api.chunk.listener.RetryProcessListener;
import javax.inject.Named;

@Named
public class RetyProcessExceptionListener implements RetryProcessListener {
	
    @Override
    public void onRetryProcessException(Object item, Exception ex) throws Exception {
        System.out.println("RetyProcessExceptionListener" + item.toString() + ": " + ex.getMessage());
    }
}
