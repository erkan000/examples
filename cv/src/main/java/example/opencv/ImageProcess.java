package example.opencv;

import org.opencv.core.Mat;

public class ImageProcess {


	public static void main(String[] args) {	
		OpenCvUtil.init();
		Mat sourceImage = OpenCvUtil.getImage("src/main/resources/img.jpg");
		Mat imgGrayScale = OpenCvUtil.convertImageToGrayScale(sourceImage);
		Mat imgNoiseless = OpenCvUtil.removeNoise(sourceImage);
		Mat imgCanny = OpenCvUtil.applyCanny(sourceImage);
		OpenCvUtil.writeImageToFile("src/main/resources/imgGray.jpg", imgGrayScale);
		OpenCvUtil.writeImageToFile("src/main/resources/imgNoise.jpg", imgNoiseless);
		OpenCvUtil.writeImageToFile("src/main/resources/imgCanny.jpg", imgCanny);		
	}

}
