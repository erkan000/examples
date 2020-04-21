## Computer Vision

### OpenCV
OpenCV (Open source computer vision) is a library of programming functions mainly aimed at real-time computer vision.
FaceRecognize.java demostrates this lib.

### DLJ
Deep Java Library (DJL) is an open-source, high-level, framework-agnostic Java API for deep learning.
 
DetectObjects.java , we load a SSD (Single Shot MultiBox Detector) model from the MXNet model zoo.
The Model Zoo is a collection of pre-trained models, which are ready to use out of the box.

### Tesseract OCR
Tesseract is a neural net (LSTM) based OCR engine which is focused on line recognition. 

RecognizeText.java , is a sample OCR. In fact not every image standart like this. Before OCR, we must process the image like scaling.

Sample uses tessdata folder which obtained from "tesseract-ocr-w64-setup-v5.0.0.20190623.exe" Exe also has a command line utility for run ocr. At java implementation there is np dpi option but command line tool has.
You can set like this:

	"--dpi 300"

My opinion is to have python at cv works!

