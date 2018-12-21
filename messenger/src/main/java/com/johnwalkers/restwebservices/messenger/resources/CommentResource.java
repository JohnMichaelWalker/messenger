package com.johnwalkers.restwebservices.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/") // Optional, this does nothing on sub-resources
public class CommentResource {
	
	@GET
	public String test() {
		return "new sub resource";
	}
	
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long commentId,
			     @PathParam("messageId") long messageId) {
		return "Method to return commentId: " + commentId + System.lineSeparator()
		  + "messageId: " + messageId;
	}
}
