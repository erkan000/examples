package listener;

import javax.batch.api.chunk.listener.SkipProcessListener;
import javax.inject.Named;

@Named
public class SkipProcessExceptionListener implements SkipProcessListener {
    @Override
    public void onSkipProcessItem(Object t, Exception e) throws Exception {
        System.out.println("SkipProcessExceptionListener : " + t.toString() + ": " + e.getMessage());
    }
}
