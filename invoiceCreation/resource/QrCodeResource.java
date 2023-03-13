package com.alacriti.invoiceCreation.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.service.QrCodeSevice;
import com.alacriti.invoiceCreation.vo.QrCode;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/qrCode")
public class QrCodeResource {

	private static Logger log = Logger.getLogger(QrCodeResource.class.getName());
	QrCodeSevice qrCodeService = new QrCodeSevice();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<QrCode> getQrCode() {

		log.info("in QrCodeResource--->getQrCode Method starts.");
		
		try 
		{
			return qrCodeService.getAllPaths();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Path("/{shopQrCodePath}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String scanQrCode(QrCode qrCode) throws FileNotFoundException, NotFoundException, IOException {

		log.info("in QrCodeResource--->scanQrCode Method starts.");
		String str = qrCodeService.scanQrCode(qrCode.getShopQrCodePath());
		System.out.println(str + " resource output");
		return str;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public QrCode addQrCode(QrCode qrCode) throws IOException, WriterException {
		
		log.info("in QrCodeResource--->addQrCode Method starts.");
		return qrCodeService.generateQrCode(qrCode);
	}

}
