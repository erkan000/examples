package example.opencv;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import nu.pattern.OpenCV;

public class DetectFingers {

	public static void main(String[] args) {
//		https://github.com/britphan/opencv-hand
		DetectFingers app = new DetectFingers();
		app.mainLoop();
	}
	
	private void mainLoop() {
		
		OpenCV.loadShared();

//		VideoCapture camera = new VideoCapture("C:/Users/SAAD/Desktop/ratiler/projects/motion.mp4");
		VideoCapture cap = new VideoCapture(0); // To open default camera using default backend just pass 0
		cap.set(10, 230); // set image brightness
		cap.set(3, 640);  // set frameWidth
		cap.set(4, 480);  // set frameHeight
		
		// Create main window
		JFrame jFrame = HighGui.createJFrame("Webcam", HighGui.WINDOW_AUTOSIZE);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(780, 700);
		
		JPanel panel = new JPanel();
		JLabel videoPanel = new JLabel();
		panel.add(videoPanel);
		jFrame.setContentPane(panel);
		
		JSlider hueMin = createSlider(0,180,5);
		JSlider hueMax = createSlider(26,180,30);
		JSlider saturationMin = createSlider(50,255,50);
		JSlider saturationMax = createSlider(0,255,90);
		JSlider valueMin = createSlider(0,255,5);
		JSlider valueMax = createSlider(0,255,255);
		
		jFrame.add(hueMin);
		jFrame.add(hueMax);
		jFrame.add(saturationMin);
		jFrame.add(saturationMax);
		jFrame.add(valueMin);
		jFrame.add(valueMax);

		int index = 0;
		if (cap.isOpened()) {
			while (true) {
				Mat frame = new Mat();
				Mat image = new Mat();
				Mat mask = new Mat();
				cap.read(frame); // get webcam image
				
//				Convert RGB image to grayscale and eliminate noise
				Imgproc.blur(frame, image, new Size(7d, 7d));
				Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2HSV);

				// get thresholding values from the UI
				// remember: H ranges 0-180, S and V range 0-255
				Scalar minValues = new Scalar(hueMin.getValue(), saturationMin.getValue(), valueMin.getValue());
				Scalar maxValues = new Scalar(hueMax.getValue(), saturationMax.getValue(), valueMax.getValue());

				// threshold HSV image
				Core.inRange(image, minValues, maxValues, mask);
				
				Mat result = frame;  // for errors set same CAM image
				try {
					result = generateContours(mask, frame);
				} catch (Exception e) {
					
				}
				
				videoPanel.setIcon(new ImageIcon(HighGui.toBufferedImage(result)));
				videoPanel.repaint();

//				HighGui.imshow("CAM", cevap);
//				index = HighGui.waitKey(1);
				if (index == 27) { // ESC key
					break;
				}
			}
		}
	}

	private JSlider createSlider(int min, int max, int defaultValue) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL);
		slider.setMaximum(max);
		slider.setMinimum(min);
		slider.setValue(defaultValue);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		return slider;
	}

	private Mat generateContours(Mat maskedImage, Mat frame){

		List<MatOfPoint> contours = new ArrayList<>();
		Mat hierarchy = new Mat();

		Imgproc.findContours(maskedImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0,0));
		List<MatOfInt> hull = new ArrayList<MatOfInt>();

		List<MatOfInt4> defects = new ArrayList<MatOfInt4>();
		for(int i=0; i < contours.size(); i++){
			hull.add(new MatOfInt());
			defects.add(new MatOfInt4());
		}

		//generate the convex hull and defects 
		for(int i=0; i < contours.size(); i++){
			Imgproc.convexHull(contours.get(i), hull.get(i));
			Imgproc.convexityDefects(contours.get(i),hull.get(i), defects.get(i));
		}

		// Loop over all contours
		List<Point[]> hullpoints = new ArrayList<Point[]>();
		for(int i=0; i < hull.size(); i++){
			Point[] points = new Point[hull.get(i).rows()];

			// Loop over all points that need to be hulled in current contour
			for(int j=0; j < hull.get(i).rows(); j++){
				int index = (int)hull.get(i).get(j, 0)[0];
				points[j] = new Point(contours.get(i).get(index, 0)[0], contours.get(i).get(index, 0)[1]);
			}
			hullpoints.add(points);
		}

		// Convert Point arrays into MatOfPoint
		List<MatOfPoint> hullmop = new ArrayList<MatOfPoint>();
		for(int i=0; i < hullpoints.size(); i++){
			MatOfPoint mop = new MatOfPoint();
			mop.fromArray(hullpoints.get(i));
			hullmop.add(mop);
		}

		// Draw contours + hull results
		int biggestContourIndex = findBiggestContour(contours);
		int fingerCount = 1;
		Scalar color = new Scalar(0, 255, 0);   // Green
		for(int i=0; i < contours.size(); i++){
			//choose only the biggest contour
			if(i == biggestContourIndex){
				Imgproc.drawContours(frame, contours, i, new Scalar(0,0,255),2);
				for(int j=0; j< defects.get(i).toList().size()-3; j+=4){
//        			store the depth of the defect
					float depth = defects.get(i).toList().get(j+3) / 256;
					if(depth > 10){
						//store indexes of start, end, and far points
						int startid = defects.get(i).toList().get(j);
						//store the point on the contour as a Point object
						Point startPt = contours.get(i).toList().get(startid);
						int endid = defects.get(i).toList().get(j+1);
						Point endPt = contours	.get(i).toList().get(endid);
						int farid = defects.get(i).toList().get(j+2);
						Point farPt = contours.get(i).toList().get(farid);

						if (isFinger(defects.get(i),contours.get(i),j)) {
							if (fingerCount < 5)
								fingerCount++;
							System.out.println("Distance from start to far: " + distanceFormula(startPt,farPt));
							System.out.println("Distance from end to far:   " + distanceFormula(endPt,farPt));
							System.out.println("Angle of defect:            " + getAngle(startPt,endPt,farPt));
							//draw line from start to end
							Imgproc.line(frame,startPt,endPt,new Scalar(255,255,255),2);	
							//draw line from start to far point
							Imgproc.line(frame,startPt,farPt,new Scalar(255,255,255),2);	
							//draw line from end to far point
							Imgproc.line(frame,endPt,farPt,new Scalar(255,255,255),2);
							//draw circle around far point
							Imgproc.circle(frame,farPt,4,new Scalar(255,255,255),2);
						} else {
							//draw line from start to end
							Imgproc.line(frame,startPt,endPt,new Scalar(255,0,0),2);	
							//draw line from start to far point
							Imgproc.line(frame,startPt,farPt,new Scalar(255,0,0),2);	
							//draw line from end to far point
							Imgproc.line(frame,endPt,farPt,new Scalar(255,0,0),2);
							//draw circle around far point
							Imgproc.circle(frame,farPt,4,new Scalar(255,0,0),2);
						}
					}
				}
				//draw convex hull of biggest contour
				Imgproc.drawContours(frame, hullmop, i, new Scalar(0,255,255),2);

			}
			else //draw smaller contours in green 
			{
				Imgproc.drawContours(frame, contours, i, color);
			}
		}
		if(fingerCount != 1)
			System.out.println(fingerCount + " finger(s) detected");

		return frame;

	}

	// helper method to find biggest contour
	private int findBiggestContour(List<MatOfPoint> contours) {
		int indexOfBiggestContour = -1;
		double sizeOfBiggestContour = 0;
		for (int i = 0; i < contours.size(); i++){
			if(Imgproc.contourArea(contours.get(i)) > sizeOfBiggestContour){
				sizeOfBiggestContour = Imgproc.contourArea(contours.get(i));
				indexOfBiggestContour = i;
			}
		}
		return indexOfBiggestContour;
	}

	private boolean isFinger(MatOfInt4 defect,MatOfPoint contour,int j) {
		Rect boundingRect= Imgproc.boundingRect(contour);
		int tolerance = boundingRect.height / 5;
		double angleTol = 95;	
		//store indexes of start, end, and far points
		int startid = defect.toList().get(j);
		//store the point on the contour as a Point object
		Point startPt = contour.toList().get(startid);
		int endid = defect.toList().get(j+1);
		Point endPt = contour.toList().get(endid);
		int farid = defect.toList().get(j+2);
		Point farPt = contour.toList().get(farid);

		if (distanceFormula(startPt,farPt)>tolerance && 
				distanceFormula(endPt,farPt)>tolerance && 
				getAngle(startPt,endPt,farPt) < angleTol &&
				endPt.y <= (boundingRect.y + boundingRect.height - boundingRect.height/4) &&
				startPt.y <= (boundingRect.y + boundingRect.height - boundingRect.height/4))
			return true;

		return false;
	}	

	// use Law of Cosines to find angle between 3 points
	private double getAngle(Point start, Point end, Point far) {
		//distance between start and far
		double a = distanceFormula(start,far);
		//distance between end and far
		double b = distanceFormula(end,far);
		//distance between start and end (side c of triangle)
		double c = distanceFormula(start,end);
		//Law of Cosines
		double angle = Math.acos((a*a + b*b - c*c) / (2*a*b));
		angle = angle*180/Math.PI;
		return angle;
	}

	private double distanceFormula(Point start, Point end) {
		return Math.sqrt(Math.abs(Math.pow(start.x-end.x, 2) + Math.pow(start.y-end.y, 2)));
	}

}
