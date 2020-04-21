package example.opencv;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 * 
 * @author Erkan
 *
 */
public class OpenCvUtil {

	public static Mat getImage(String path) {
		return Imgcodecs.imread(path);
	}
	
	public static void writeImageToFile(String path, Mat image) {
		Imgcodecs.imwrite(path, image);
	}
	
	public static Mat convertImageToGrayScale(Mat sourceImage) {
		Mat destImage = new Mat();
		Imgproc.cvtColor(sourceImage, destImage, Imgproc.COLOR_BGR2GRAY);
		return destImage;
	}
	
	public static Mat removeNoise(Mat sourceImage) {
		Mat destImage = new Mat();
		Imgproc.medianBlur(sourceImage, destImage, 5);
		return destImage;
	}
	
	public static Mat applyCanny(Mat sourceImage) {
		Mat destImage = new Mat();
		Imgproc.Canny(sourceImage, destImage, 100, 200);
		return destImage;
	}
	
	public static MatOfRect detectFace(Mat sourceImage) {
		String xmlFile = "src/main/resources/lbpcascade_frontalface.xml"; 
		CascadeClassifier classifier = new CascadeClassifier(xmlFile);		
		MatOfRect faceDetections = new MatOfRect();		
		classifier.detectMultiScale(sourceImage, faceDetections);
		return faceDetections;
	}
	
	public static void drawRectangle(Mat sourceImage, Rect rect) {
		Imgproc.rectangle(sourceImage,                                          
				new Point(rect.x, rect.y),                            // bottom left
				new Point(rect.x + rect.width, rect.y + rect.height), // top right
				new Scalar(0, 0, 255),
				3                                                     // RGB colour
				);
	}
	
	public static void init() {
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		This is for maven jar
		nu.pattern.OpenCV.loadShared();
		
//		Use in case loadShared() doesn't work
//		nu.pattern.OpenCV.loadLocally();
	}
}
