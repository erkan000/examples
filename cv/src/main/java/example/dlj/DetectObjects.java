package example.dlj;

import ai.djl.MalformedModelException;
import ai.djl.modality.cv.ImageVisualization;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.modality.cv.util.BufferedImageUtils;
import ai.djl.mxnet.zoo.MxModelZoo;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

//	https://github.com/awslabs/djl/tree/master/examples/src/main/java/ai/djl/examples/training

public class DetectObjects {

	private static final Logger logger = LoggerFactory.getLogger(DetectObjects.class);

	public static void main(String[] args) throws MalformedModelException, ModelNotFoundException, TranslateException, IOException {
		DetectedObjects detectedObjects = new DetectObjects().predict();
		logger.info("{}", detectedObjects);
	}

	public DetectedObjects predict() throws MalformedModelException, ModelNotFoundException, IOException, TranslateException {
		Path imageFile = Paths.get("src/main/resources/Solvay_conference_1927.jpg");
		BufferedImage img = BufferedImageUtils.fromFile(imageFile);

		ZooModel<BufferedImage, DetectedObjects> model = 
				MxModelZoo.SSD.loadModel(new ProgressBar());

		DetectedObjects predictor = model.newPredictor().predict(img);
		ImageVisualization.drawBoundingBoxes(img, predictor);
		ImageIO.write(img, "png", new File("src/main/resources/detected_objects.png"));
		model.close();
		return predictor;
	}

}
