package com.alacriti.invoiceCreation.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.dao.QrCodeDAO;
import com.alacriti.invoiceCreation.vo.QrCode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;


public class QrCodeSevice {

	private static Logger log = Logger.getLogger(QrCodeSevice.class.getName());
	QrCodeDAO qrCodeDao = new QrCodeDAO();

	public QrCode generateQrCode(QrCode qrCode) throws IOException, WriterException {
		
		log.info("in QrCodeSevice--->generateQrCode Method starts.");
		String data = qrCode.getShopName();
		String path ="/home/poojithak/InstantInvoiceCreation/InvoiceCreation/src/assets";
		path = path+File.separator+qrCode.getShopName()+".png";

		BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
		MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(path));
		
		qrCode.setShopQrCodePath("assets"+File.separator+qrCode.getShopName()+".png");
		
		log.info("in QrCodeSevice--->generateQrCode Method ends.");
		return qrCodeDao.addQrCode(qrCode);

	}


	public String scanQrCode(String shopQrCodePath) throws FileNotFoundException, IOException, NotFoundException {
		
		log.info("in QrCodeSevice--->scanQrCode Method starts.");
		String path ="/home/poojithak/InstantInvoiceCreation/InvoiceCreation/src"+File.separator+shopQrCodePath;

		BufferedImage bf = ImageIO.read(new FileInputStream(path));
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bf)));
		Result result = new MultiFormatReader().decode(bitmap);
		
		String response = "{\"msg\":\"" + result + "\"}";
		log.info("in QrCodeSevice--->scanQrCode Method ends.");
		return response;
	
	}


	public List<QrCode> getAllPaths() {
		
		log.info("in QrCodeSevice--->getAllPaths Method starts.");
		return qrCodeDao.getAllPaths();
	}


}
