
package com.tesco.rs.resource;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.tesco.rs.domain.Customer;
import com.tesco.rs.dto.CustomerDto;
import com.tesco.rs.service.CustomerService;
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
@Path("/v1/customers")
@Api(value = "customers", description = "product operations")
public class CustomerResource extends AbstractResource<Customer, CustomerDto> {

	@Inject
	private CustomerService customerService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response getCustomer(@QueryParam(value = "id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		if (id != null) {
			return Response.ok(customerService.findOne(id, getDomainType())).status(200).build();
		} else {
			return Response.ok(customerService.findAll()).status(200).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get registeredUser by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 500, message = "server error") })
	public Response crateCustomer(@ApiParam Customer object) throws JsonProcessingException, IOException {
		String id = UUID.randomUUID().toString();
		object.setId("customer:id:" + id);
		customerService.create(object, getDomainType());
		return Response.ok().header("id", "customer:id:" + id).status(201).build();
	}

	@Override
	public GenericService getGenericService() {
		return customerService;
	}
}
