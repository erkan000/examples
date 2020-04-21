package example.opencv;

import java.io.IOException;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;

public class FaceRecognize {

	public static void main(String[] args) throws IOException {		
		OpenCvUtil.init();

		Mat sourceImage = OpenCvUtil.getImage("src/main/resources/Solvay_conference_1927.jpg");		
		MatOfRect faceDetections = OpenCvUtil.detectFace(sourceImage);	

		System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

		for (Rect rect : faceDetections.toArray()) {
			OpenCvUtil.drawRectangle(sourceImage, rect);
		}

		OpenCvUtil.writeImageToFile("src/main/resources/detected_faces.jpg", sourceImage);
	}

}
