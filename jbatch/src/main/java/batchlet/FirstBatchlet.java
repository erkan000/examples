package batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FirstBatchlet extends AbstractBatchlet {
 
	@Inject
    JobContext jobContext;
	
    @Override
    public String process() throws Exception {
    	System.out.println("This is a batchlet, it runs only once"); 	
        return BatchStatus.COMPLETED.toString();
    }
}
