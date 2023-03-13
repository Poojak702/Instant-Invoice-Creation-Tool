package com.alacriti.invoiceCreation.resource;

import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.service.ItemService;
import com.alacriti.invoiceCreation.vo.Item;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/items")
public class ItemResource {
	
	private static Logger log = Logger.getLogger(ItemResource.class.getName());
	ItemService itemService = new ItemService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> addItem(Item item) {
		
		log.info("in ItemResource--->addItem Method starts.");
		System.out.println("Hi");
		return itemService.addItem(item);
	}
	
	@GET
	@Path("/billId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItemsById(@PathParam("id") int id){
		
		log.info("in ItemResource--->getItemsById Method starts.");
		return itemService.getItemsById(id);
	}
	
	@GET
	@Path("/userId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Item> getBillPathByUserId(@PathParam("id") int id){
		
		log.info("in ItemResource--->getBillPathByUserId Method starts.");
		return itemService.getBillPathByUserId(id);
	}
	

}
