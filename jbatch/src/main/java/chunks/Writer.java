package chunks;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named
public class Writer extends AbstractItemWriter{
	
	@Override
	public void writeItems(List<Object> items) throws Exception {
		 LOGGER.log(Level.INFO, "Writing data!");
		 items.stream().map(String.class::cast).forEach(System.out::println);
	}

	private static final Logger LOGGER = Logger.getLogger(Writer.class.getName());
}
