package restcourse.resources;

import models.Kilometer;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


@Path("/convertToMiles")
public class ConvertToMilesService {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getTestService() {
    Kilometer km = new Kilometer(2000);
    km.convertToMiles();
    return km.toString();
  }
}

  /*

@PUT
  @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Response puPerson(Person p) {

    Response res;
    res = Response.ok().build();
    System.out.println("gota person maaaan");
    System.out.println(p.getName());

    return res;

  }
  */