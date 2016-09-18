package com.tesco.rs.resource;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.tesco.rs.domain.DestinationLocation;
import com.tesco.rs.dto.DestinationLocationDto;
import com.tesco.rs.service.DestinationLocationService;
import com.tesco.rs.service.GenericService;
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
@Path("/v1/destiantionlocation")
@Api(value = "destiantionlocation", description = "destiantionlocation operations")
public class DestinationLocationResource extends AbstractResource<DestinationLocation, DestinationLocationDto> {

	@Inject
	private DestinationLocationService destinationLocationService;

	@Context
	private UriInfo info;

	@Override
	public GenericService getGenericService() {
		return destinationLocationService;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get destiantionlocation by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response getUsers(@QueryParam(value = "id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		return Response.ok(destinationLocationService.findOne(id, getDomainType())).status(200).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Enter destiantionlocation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response createRegisteration(@ApiParam DestinationLocation object)
			throws JsonProcessingException, IOException {
		String id = UUID.randomUUID().toString();
		object.setId("destinationlocation:" + id);
		destinationLocationService.create(object, getDomainType());
		return Response.ok().header("id", "destinationlocation:" + id).status(201).build();
	}

}
