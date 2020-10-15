package chunks;

import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Processor implements ItemProcessor{
	
	@Inject
    JobContext jobContext;
	
	@Override
	public Object processItem(Object item) throws Exception {
		LOGGER.log(Level.INFO, "Processing");
		
		String name = (String)item;		
		if(name.equals("Test1")) {
			int count = (int) jobContext.getTransientUserData();
			throw new NumberFormatException(count + ". eleman format yanlis");
		}else if(name.equals("Test2")) {
			throw new ConnectException();
		}
		name = name + "+processed";
		return name;
	}	

	private static final Logger LOGGER = Logger.getLogger(Processor.class.getName());
	
}
