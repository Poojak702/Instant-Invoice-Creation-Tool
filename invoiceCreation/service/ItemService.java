package com.alacriti.invoiceCreation.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.dao.ItemDAO;
import com.alacriti.invoiceCreation.vo.Item;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ItemService {

	private static Logger log = Logger.getLogger(ItemService.class.getName());
	ItemDAO itemDao = new ItemDAO();
	
	public List<Item> addItem(Item item) {
		
		log.info("in ItemResource--->addItem Method starts.");
		System.out.println("Service Layer "+item.getBillPath());
		List<Item> items = new ArrayList<>();
		items = extractDataFromBill(item);
		
		try {
			itemDao.addBill(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("in ItemResource--->addItem Method ends.");
		return itemDao.addItems(items);
	}
	
	public static List<Item> extractDataFromBill(Item item) {
		
		log.info("in ItemResource--->extractDataFromBill Method starts.");
		List<Item> items = new ArrayList<>();
		
		try {
			
			Tesseract tesseract = new Tesseract();
	    	tesseract.setDatapath("");
	    	tesseract.setLanguage("eng");
	        String data = tesseract.doOCR(new File("/home/poojithak/InstantInvoiceCreation/InvoiceCreation/src/"+item.getBillPath()));
	        System.out.println(data);
	        items = getDataInFormate(data);
		} catch (TesseractException e) {
			e.printStackTrace();
		}	
		
		log.info("in ItemResource--->extractDataFromBill Method ends.");
		return items;
	}

	
	public static List<Item> getDataInFormate(String data) {
		
		log.info("in ItemResource--->getDataInFormate Method starts.");
		String[] parts = data.split("( |\n)+");
		Item item=new Item();
		int itemvalue=0;
    	ArrayList<Item> items=new ArrayList<>();
    	
    	for(int i=2;i<parts.length;i++) {
    		
    		System.out.println();
    		if(itemvalue==2) {
    			items.add(item);
    			System.out.println("items : "+items.toString());
    			item=new Item();
    			itemvalue=0;
    		}
    		
    		if(i%2!=0) {
    			item.setItemPrice(Integer.parseInt(parts[i]));
    			itemvalue++;
    		}
    		else {
    			item.setItemName(parts[i]);
    			itemvalue++;
    		}	
    	}
    	
    	if(itemvalue==2) {
    		items.add(item);
    	}
    	
		log.info("in ItemResource--->getDataInFormate Method ends.");
		return items;
	}
	

	public List<Item> getItemsById(int id) {
		
		log.info("in ItemResource--->getItemsById Method starts.");
		return itemDao.getItemsById(id);

	}

	public List<Item> getBillPathByUserId(int id) {
		
		log.info("in ItemResource--->getBillPathByUserId Method starts.");
		Item item = new Item();
		item.setUserId(id);
		return itemDao.getBillPathByUserId(item);
	}
}
