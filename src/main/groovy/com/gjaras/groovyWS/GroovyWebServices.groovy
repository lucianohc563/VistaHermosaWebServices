package com.gjaras.groovyWS

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
class GroovyWebServices {

    static final Logger LOG = LoggerFactory.getLogger(GroovyWebServices.class)

    @GET
    @Path("/testws")
    @Produces(value=["application/json"])
    def Response testWS() {
        LOG.info("TESTING WEBSERVICE IMPLEMENTED WITH GROOVY")
        return Response.ok("{\"status\":\"success\"}", MediaType.APPLICATION_JSON + ";charset=UTF-8").build()

    }
    
    @POST
    @Path("/requestauth")
    @Consumes(value=["application/json"])
    @Produces(value=["application/json"])
    public Response requestAuth(String content) {
        LOG.info("Parameter received: "+content);
        LOG.info("Request for Auth initiated");
        String jsonString = "{\"response\":\""+parameter+"\"}";
        return Response.ok(jsonString, MediaType.APPLICATION_JSON + ";charset=UTF-8").build();

    }
}
