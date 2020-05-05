package example.producer;

import java.io.IOException;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class TestProducer {	
	
	public static void main(String[] args) throws IOException {
		new TestProducer().test();
	}

	private void test() throws IOException {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();		
        FileService service = container.select(FileService.class).get();
		service.writeTextToFile("Erkan!");
		container.shutdown();
	}

}
