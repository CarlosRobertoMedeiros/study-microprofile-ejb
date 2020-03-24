package br.com.roberto.javaee.excecoes;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.roberto.javaee.dto.MensagemErroDto;

//@Provider -> Não é preciso usar agora estou sem front end
public class ConstraintValidationMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response
				.status(Response.Status.BAD_REQUEST)
				.entity(MensagemErroDto.build(
						exception.getConstraintViolations()
							.stream()
							.map(constraintViolation -> constraintViolation.getMessage())
							.collect(Collectors.toList())))
				.build();
	}
	

}
