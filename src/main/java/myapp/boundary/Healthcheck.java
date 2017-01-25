package myapp.boundary;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import java.time.LocalDateTime;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/healthcheck")
public class Healthcheck {

	@GET
	public Response alive() {
		JsonObject alive = Json.createObjectBuilder().add("alive", ISO_DATE_TIME.format(LocalDateTime.now())).build();
		return Response.ok(alive).build();
	}
}
