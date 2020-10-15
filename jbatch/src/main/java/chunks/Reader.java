package chunks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Reader extends AbstractItemReader {

	@Inject
    JobContext jobContext;
	
	private List<String> liste = null;
	private int count;
	
    @Override
    public void open(Serializable checkpoint) throws Exception {
    	count = 0;
        liste = new ArrayList<String>();
        liste.add("Apple");
        liste.add("Watermelon");
        liste.add("Tomato");
        LOGGER.log(Level.INFO, "All data read!");
    }
	
	@Override
	public Object readItem() throws Exception {
		LOGGER.log(Level.INFO, "Reading one item!");
		if(count < liste.size()) {
			jobContext.setTransientUserData(count);
			return liste.get(count++);
		}
        return null;
	}

	private static final Logger LOGGER = Logger.getLogger(Reader.class.getName());
}
