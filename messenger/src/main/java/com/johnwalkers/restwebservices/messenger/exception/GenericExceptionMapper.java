package com.johnwalkers.restwebservices.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.johnwalkers.restwebservices.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(exception.getMessage());
		errorMessage.setErrorCode(403);
		errorMessage.setDocumentation("this is the documentation");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}


}
