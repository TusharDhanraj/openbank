package com.banking.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import com.banking.request.CreateViewRequest;

@Path("home")
@Consumes("application/json")
public class Resource {
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}
	
@POST
	@Path("hello1")
	@Produces(MediaType.APPLICATION_JSON)
@Consumes("application/json")
	public String helloWorldPost(String jsonRequest) {
	ObjectMapper mapper=new ObjectMapper();
		return jsonRequest;
	}
}
