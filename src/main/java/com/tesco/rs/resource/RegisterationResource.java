package com.tesco.rs.resource;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.tesco.rs.domain.Registeration;
import com.tesco.rs.dto.RegisterationDto;
import com.tesco.rs.service.GenericService;
import com.tesco.rs.service.RegisterationService;
import com.tesco.rs.util.AbstractResource;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author vagrant
 *
 */
@Path("/v1/registeration")
@Api(value = "registeration", description = "registeration operations")
public class RegisterationResource extends AbstractResource<Registeration, RegisterationDto> {

	@Inject
	private RegisterationService registerationService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response getUsers(@QueryParam(value = "id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (id != null) {
			return Response.ok(findOne(id)).status(200).build();
		} else {
			return Response.ok(findAll()).status(200).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response createRegisteration(@ApiParam Registeration object) throws JsonProcessingException, IOException {
		String id = UUID.randomUUID().toString();
		object.setId("registerationId:" + id);
		create(object);
		return Response.ok().header("id", "registerationId:" + id).status(201).build();
	}

	@Override
	public GenericService getGenericService() {
		return registerationService;
	}
}
