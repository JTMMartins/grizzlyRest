package pt.noshio.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test2")
public class EndPoint2 {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sendSomeResponse() {
		return "HELLO FROM ENDPOINT 2 - JAXRS-JavaSE";
	}

}
