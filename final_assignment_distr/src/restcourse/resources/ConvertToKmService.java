package restcourse.resources;

import models.Miles;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


/*
 http://localhost:9998/convertToKm/1500, provide the var miles to convert to km
*/

@Path("/convertToKm/{var}")
public class ConvertToKmService {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getKmService(@PathParam("var") String var) {
    Miles mile = new Miles(Float.parseFloat(var));
    mile.convertToKm();
    return mile.toString();
  }
}
