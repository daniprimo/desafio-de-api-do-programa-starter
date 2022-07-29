package gft.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import gft.dto.exception.ApiErrorsDTO;

@ControllerAdvice
public class CustonRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DesafioException.class })
	public ResponseEntity<ApiErrorsDTO> handleDesafioResponseEntity(DesafioException ex, WebRequest request) {

		String errors = "Erro no sistema";

		ApiErrorsDTO apiErrors = new ApiErrorsDTO(ex.getMessage(), errors, HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<ApiErrorsDTO>(apiErrors, new HttpHeaders(), apiErrors.getStatus());
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<ApiErrorsDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {

		String error = "Recurso não encontrado";

		ApiErrorsDTO apiError = new ApiErrorsDTO(ex.getMessage(), error, HttpStatus.NOT_FOUND);

		return new ResponseEntity<ApiErrorsDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
