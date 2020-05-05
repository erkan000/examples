package example.producer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import ch.qos.logback.classic.Logger;

public class FileProducer {
	
	@Inject
	private Logger log;

	@Produces
	private Path produceFile() throws IOException {
		Path directory = FileSystems.getDefault().getPath("src/main/resources");
		if (!directory.toFile().exists())
			Files.createDirectory(directory);
		Path file = directory.resolve("test.txt");
		if (!file.toFile().exists())
			Files.createFile(file);
		log.debug("Created file!");
		return file;
	}
	
	@SuppressWarnings("unused") // Because @Disposes annotation
	private void closeFile(@Disposes Path p) {
		log.debug("Close resources");
	}
}
