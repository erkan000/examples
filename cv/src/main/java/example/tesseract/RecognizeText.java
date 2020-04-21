package example.tesseract;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class RecognizeText {

	public static void main(String[] args) {
		
		File imageFile = new File("src/main/resources/img.jpg");
		// JNA Interface Mapping
		ITesseract instance = new Tesseract();
		// JNA Direct Mapping
		// ITesseract instance = new Tesseract1(); 
		
		// set Tesseract-OCR data path.
		instance.setDatapath("src/main/resources/tessdata/");
		try {
			String result = instance.doOCR(imageFile);
			System.out.println("Scanned text is: " + result);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}

	}

}
