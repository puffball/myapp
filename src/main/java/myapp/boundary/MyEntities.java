package myapp.boundary;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import myapp.control.MyServiceBean;
import myapp.entity.MyEntity;

@Path("/myentities")
@Produces(MediaType.APPLICATION_JSON)
public class MyEntities {

	@Inject
	private MyServiceBean service;
	
	@GET
	public Response findAll() {
		List<MyEntity> entities = service.findAll();
		return Response.ok(entities).build();
	}

	@GET
	@Path("{id}")
	public Response findById(@PathParam("id") long id) {
		MyEntity entity = service.findById(id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(MyEntity entity, @Context UriInfo uriInfo) {
		MyEntity result = service.merge(entity);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(result.getId())).build();
		return Response.created(location).entity(result).build();
	}
}
