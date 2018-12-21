package com.johnwalkers.restwebservices.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.johnwalkers.restwebservices.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorMessage(exception.getMessage());
		errorMessage.setErrorCode(404);
		errorMessage.setDocumentation("this is the documentation");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}


}
