package com.gjaras.groovyWS

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.*
import com.gjaras.dao.UsuarioDAO
import com.gjaras.pojos.Usuario
import com.gjaras.util.Config
import groovy.json.JsonSlurper
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
    public Response requestAuth(@HeaderParam("accessToken")String accessToken, String content) {
        LOG.info("Request for Auth initiated")
        LOG.info("token: $accessToken content: ${content}")
        if(accessToken.equalsIgnoreCase(Config.get("ACCESS_TOKEN"))){
            LOG.info("correct access token")
            try{
                def parsedJson = new JsonSlurper().parseText(content)
                def result
                LOG.info(parsedJson.toString())
                UsuarioDAO usuDao = new UsuarioDAO()
                Usuario usu = new Usuario(parsedJson.name,parsedJson.pass)
                Usuario outcome = usuDao.getUsuarioForAuth(usu)
                if(outcome){
                    result = [[result: "authenticated"],[type: outcome.getTipoUsuario()]]
                    return Response.ok(groovy.json.JsonOutput.toJson(result), MediaType.APPLICATION_JSON + ";charset=UTF-8").build()
                }else{
                    result = [[result: "incorrect"]]
                    return Response.ok(groovy.json.JsonOutput.toJson(result), MediaType.APPLICATION_JSON + ";charset=UTF-8").build()
                }
            }catch(Exception ex){
                return Response.ok(groovy.json.JsonOutput.toJson([result: "Server Error: ${ex.toString()}"]),MediaType.APPLICATION_JSON + ";charset=UTF-8").build()
            }
        }else{
            LOG.info("invalid access token")
            return Response.ok(groovy.json.JsonOutput.toJson([result: "invalid access token"]),MediaType.APPLICATION_JSON + ";charset=UTF-8").build()
        }

    }
}
