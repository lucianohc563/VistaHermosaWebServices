package com.gjaras.integracionwebservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
/**
 * Class with rest web services. It allows: document validation, to send a document to SII, to preview a document, and
 * to download the PDF of the document.
 *
 * @author Gabriel Oberreuter <gabriel.oberreuter@opciones.cl>
 */
@Path("/")
public class WebServices {

    private static final Logger LOG = LoggerFactory.getLogger(WebServices.class);

    @GET
    @Path("/testws")
    @Produces({MediaType.APPLICATION_JSON})
    public Response testWS() {
        LOG.info("TESTING WEBSERVICE ");
        JsonProducer jp = new JsonProducer();
        String jsonString = (String)jp.listToJSONString();
        return Response.ok("{\"status\":\"success\"}", MediaType.APPLICATION_JSON + ";charset=UTF-8").build();

    }
    
    @POST
    @Path("/requestauth")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response requestAuth(String parameter) {
        System.out.println("LOL");
        LOG.info("Parameter received: "+parameter);
        LOG.info("Request for Auth initiated");
        String jsonString = "{\"response\":\""+parameter+"\"}";
        return Response.ok(jsonString, MediaType.APPLICATION_JSON + ";charset=UTF-8").build();

    }
}
