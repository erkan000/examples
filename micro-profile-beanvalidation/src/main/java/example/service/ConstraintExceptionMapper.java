package example.service;

import java.util.Iterator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException t) {
		StringBuilder sb = new StringBuilder();
		ConstraintViolationException ex = ConstraintViolationException.class.cast(t);
		Iterator<ConstraintViolation<?>> set = ex.getConstraintViolations().iterator();
		while(set.hasNext()) {
			ConstraintViolation<?> next = set.next();
			sb.append(next.getPropertyPath());
			sb.append(System.lineSeparator());
			sb.append(next.getMessage());
			sb.append(System.lineSeparator());
			sb.append("---");
			sb.append(System.lineSeparator());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(sb.toString()).build();
	}



}
