package com.alacriti.invoiceCreation.vo;

public class Item {
	private String itemName;
	private int itemPrice;
	private int userId;
	private int billId;
	private String billPath;

	public Item() {
		super();
	}

	public Item(String itemName, int itemPrice, int userId, int billId, String billPath) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.userId = userId;
		this.billId = billId;
		this.billPath = billPath;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillPath() {
		return billPath;
	}

	public void setBillPath(String billPath) {
		this.billPath = billPath;
	}
}
