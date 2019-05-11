package restcourse.resources;

import models.Miles;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


@Path("/convertToKm")
public class ConvertToKmService {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getKmService() {
    Miles mile = new Miles(5000);
    mile.convertToKm();
    return mile.toString();
  }
}
