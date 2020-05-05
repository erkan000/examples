package example.producer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;

import ch.qos.logback.classic.Logger;

public class FileService {
	
	@Inject
	private Path file;
	
	@Inject
	private Logger log;
	
	@Inject
	private int version;

	public void writeTextToFile(String text) throws IOException {
		log.info("Injected version variable is:" + version);
		Files.write(file, text.getBytes(StandardCharsets.UTF_8));
	}

}
