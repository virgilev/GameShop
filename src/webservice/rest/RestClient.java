package webservice.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.HttpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Client;
import dao.ClientDao;

@Path("/VideoGames")
// @Consumes(MediaType.APPLICATION_JSON)
// @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class RestClient {

	@PermitAll
	@GET
	@Path("/clients")
	public Response getClients(@Context HttpRequest request) {
		List<Client> dataBaseClients = ClientDao.findAllSQL();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(dataBaseClients);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		ResponseBuilder rb;
		if (json.isEmpty()) {
			rb = Response.serverError().status(404);
		} else {
			rb = Response.ok(json).status(200);
		}
		return rb.build();
	}

	@PermitAll
	@GET
	@Path("/clients/{id}")
	// @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response getVideoGame(@PathParam("id") String id) {
		Client client = ClientDao.findSQL(id);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "[]";
		try {
			json = mapper.writeValueAsString(client);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		ResponseBuilder rb;
		if (json.isEmpty()) {
			rb = Response.serverError().status(404);
		} else {
			rb = Response.ok(json).status(200);
		}
		return rb.build();
	}
	
}
