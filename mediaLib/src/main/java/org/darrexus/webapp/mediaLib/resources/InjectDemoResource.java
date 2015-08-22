package org.darrexus.webapp.mediaLib.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("anotations")
	public String getParamsUsingAnotations(@MatrixParam("param") String param,
										   @HeaderParam("customHeaderValue") String chp,
										   @CookieParam("name") String cookie){
		return "Matrix param: " + param + "Header param: " + chp + " Cookie: " + cookie;
	}	
	//query Param (?param=value)&
	//matrix Param (;param=value)

	@GET
	@Path("context")
	public String getParamsUsingContext(){
		return "test";
	}

}