package com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OATUtils {
	// OpenCV
	static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
	public void testOpenCV(String imgPath) {
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("m = " + m.dump());
	}
	public Mat GrayScale(Mat origin) {
		Mat result = new Mat();
		// GrayScale
		Imgproc.cvtColor(origin, result, Imgproc.COLOR_BGR2GRAY);
		return result;
	}
	public void GrayScaleSave(Mat origin, String outPath) {
		Mat result = new Mat();

		// GrayScale
		Imgproc.cvtColor(origin, result, Imgproc.COLOR_BGR2GRAY);

		// Save
		Imgcodecs.imwrite(outPath, result); 
		System.out.println("GrayScaleSave: "+outPath+" 이미지 저장 완료");
	}
	public Mat GaussianBlur(Mat origin) {
		Mat result = new Mat();
		// GaussianBlur
		Imgproc.GaussianBlur(origin, result, new Size(5, 5), 0);
		return result;
	}
	public void GaussianBlurSave(Mat origin, String outPath) {
		Mat result = new Mat();

		// GaussianBlur
		Imgproc.GaussianBlur(origin, result, new Size(5, 5), 0);

		// Save
		Imgcodecs.imwrite(outPath, result); 
		System.out.println("GrayScaleSave: "+outPath+" 이미지 저장 완료");
	}
	public Mat THRESH_BINARY(Mat origin) {
		Mat result = new Mat();
		
		// Thresholding
		Imgproc.threshold(origin, result, 127, 255, Imgproc.THRESH_BINARY);
		
		return result;
	}
	public void THRESH_BINARYSave(Mat origin, String outPath) {
		Mat result = new Mat();
		
		// Thresholding
		Imgproc.threshold(origin, result, 127, 255, Imgproc.THRESH_BINARY);
		
		// Save
		Imgcodecs.imwrite(outPath, result);
	}
	public Mat THRESH_BINARY_INV(Mat origin) {
		Mat result = new Mat();
		
		// Thresholding
		Imgproc.threshold(origin, result, 127, 255, Imgproc.THRESH_BINARY_INV);
		
		return result;
	}
	public void THRESH_BINARY_INVSave(Mat origin, String outPath) {
		Mat result = new Mat();
		
		// Thresholding
		Imgproc.threshold(origin, result, 127, 255, Imgproc.THRESH_BINARY_INV);
		
		// Save
		Imgcodecs.imwrite(outPath, result);
	}
	public Mat Canny(Mat origin) {
		Mat result = new Mat();
		
		// Canny Edge
		Imgproc.Canny(origin, result, 10, 100, 3, true);
		
		return result;
	}
	public void CannySave(Mat origin, String outPath) {
		Mat result = new Mat();
		
		// Canny Edge
		Imgproc.Canny(origin, result, 10, 100, 3, true);
		
		// Save
		Imgcodecs.imwrite(outPath, result);
	}
	public int getMatWidth(Mat img) {
		int width = img.width();
		return width;
	}
	public int getMatHeight(Mat img) {
		int height = img.height();
		return height;
	}
	public int getImageWidth(Mat origin) {
		int width = origin.width();
		return width;
	}
	public int getImageHeight(Mat origin) {
		int height = origin.height();
		return height;
	}
	public void RotateSave(Mat origin, String outPath, double angle) {
		Mat rotate = new Mat();
		Mat result = new Mat();
		int width = origin.width();
		int height = origin.height();
		
		// Rotate
		rotate = Imgproc.getRotationMatrix2D(new Point(width/2,height/2), angle, 1);
		Imgproc.warpAffine(origin, result, rotate, new Size(width,height), Imgproc.INTER_AREA);
		
		// Save
		Imgcodecs.imwrite(outPath, result);
		
	}
	public Mat Rotate(Mat origin, double angle) {
		Mat rotate = new Mat();
		Mat result = new Mat();
		int width = origin.width();
		int height = origin.height();
		
		// Rotate
		rotate = Imgproc.getRotationMatrix2D(new Point(width/2,height/2), angle, 1);
		Imgproc.warpAffine(origin, result, rotate, new Size(width,height), Imgproc.INTER_AREA);
		
		return result;	
	}
	public void ShowImage(Mat img) {
		MatOfByte imgByte = new MatOfByte();
		Imgcodecs.imencode(".jpg", img, imgByte);
		byte[] imgByteArray = imgByte.toArray();
		InputStream in = new ByteArrayInputStream(imgByteArray);
		BufferedImage out = null;
		try {
			out = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JLabel(new ImageIcon(out)));
		frame.pack();
		frame.setVisible(true);
		System.out.println("Image Loaded");
	}
	public Mat rectangle(Mat edit, Mat origin) {
		List<MatOfPoint> contours = new ArrayList<>();
		Mat hierarchy = new Mat();
		Mat result = null;
		Imgproc.findContours(edit, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
		for (int idx = 0; idx >= 0; idx = (int) hierarchy.get(0, idx)[0]) {
			MatOfPoint matOfPoint = contours.get(idx);
			Rect rect = Imgproc.boundingRect(matOfPoint);
			Imgproc.drawContours(origin, contours, idx, new Scalar(0, 255, 0));
			// (rect.width<7): 제일 작은 가로 8, (rect.height < 35): 제일 작은 세로 36, (rect.x < 108): x 최소값 118, (rect.x < 318): x 최대값 282
			//System.out.println(rect.toString());
			if (rect.width<60 || rect.height<50 || rect.height>400 ||rect.x < 97 || rect.x > 565) continue;
			Imgproc.rectangle(origin, rect, new Scalar(255, 0, 0));
			//System.out.println(rect.toString());
			//result = new Mat(origin,rect);
		}
		return origin;
	}
	public void Roi(Mat img,int x, int y, int w, int h) {
		Rect roi = new Rect(x, y, w, h);
	}
	// Tesseract OCR
	public String tessOCR(String imgPath) {
		File imageFile = new File(imgPath);
		ITesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\a\\git\\FinalProject\\Finalweb\\web\\WEB-INF\\lib");
		instance.setLanguage("kor");
		String result = "";
		try {
			result = (instance.doOCR(imageFile)).trim();
			System.out.println("=========결과==========");
			System.out.println(result);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String tessOCRSetLang(String imgPath, String language) {
		File imageFile = new File(imgPath);
		ITesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\a\\git\\FinalProject\\Finalweb\\web\\WEB-INF\\lib");
		instance.setLanguage(language);
		String result = "";
		try {
			result = (instance.doOCR(imageFile)).trim();
			System.out.println("=========결과==========");
			System.out.println(result);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		return result;
	}
	// Total
	public String doOAT(String inPath) {
		// OpenCV
		Mat origin = Imgcodecs.imread(inPath);
		Mat copyImg = new Mat();
		Mat resutMat = new Mat();
		origin.copyTo(copyImg);
		copyImg = GrayScale(copyImg);
		copyImg = GaussianBlur(copyImg);
		resutMat = THRESH_BINARY_INV(copyImg);
		ShowImage(resutMat);
		
		// convert Mat object to BufferedImage object 
		MatOfByte resutMatOfByte = new MatOfByte();
	    Imgcodecs.imencode(".jpg", resutMat, resutMatOfByte);
	    byte[] byteArray = resutMatOfByte.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		BufferedImage resultBf = null;
		try {
			resultBf = ImageIO.read(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Tesseract OCR
		ITesseract instance = new Tesseract();
		instance.setDatapath("C:\\Users\\a\\git\\FinalProject\\Finalweb\\web\\WEB-INF\\lib");
		instance.setLanguage("kor");
		String result = "";
		try {
			result = (instance.doOCR(resultBf)).trim();
			System.out.println("=========결과==========");
			System.out.println(result);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		return result;
	}
}
