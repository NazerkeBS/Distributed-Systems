package restcourse.resources;

import models.TemporaryStore;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.List;

/*
get all conversions in the buffer
*/

@Path("/getAll")
public class GetAllService {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getAllService() {
    List<String> result = TemporaryStore.getAll();
    return result.toString();
  }
}
