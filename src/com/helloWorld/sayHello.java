package com.helloWorld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
public class sayHello {
	@GET
	public String greet(@QueryParam("name") String name){
		return "Hello "+ name + "!";
	}

}
