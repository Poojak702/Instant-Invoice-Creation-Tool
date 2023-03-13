package com.alacriti.invoiceCreation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	private static  Logger log = LogManager.getLogger(MyResource.class);
	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	log.info("Pooja......");
        return "Got it!";
    }
}
