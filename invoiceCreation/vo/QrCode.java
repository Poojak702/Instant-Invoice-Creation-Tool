package com.alacriti.invoiceCreation.vo;

public class QrCode {

	private String shopQrCodePath;
	private String shopName;
	
	public QrCode() {
		
	}

	public QrCode(String shopName, String shopQrCodePath) {
		super();
		this.shopQrCodePath = shopQrCodePath;
		this.shopName = shopName;
	}

	public String getShopQrCodePath() {
		return shopQrCodePath;
	}

	public void setShopQrCodePath(String shopQrCodePath) {
		this.shopQrCodePath = shopQrCodePath;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
	
}
