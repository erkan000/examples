package example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
	
	private final static Path path = Paths.get("src/test/java/example/whatsApp/params.txt");
	
	public static String read(int index) {
		List<String> text = null;
	    try {
			 text = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return text.get(index);
	}
	
	public static void write(String str){
		try {
			Files.write(path, str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
