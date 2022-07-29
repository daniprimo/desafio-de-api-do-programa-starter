package gft.dto.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorsDTO {

	private String message;
	private List<String> errors;
	private HttpStatus status;

	public ApiErrorsDTO() {
	}

	public ApiErrorsDTO(String message, List<String> errors, HttpStatus status) {
		this.message = message;
		this.errors = errors;
		this.status = status;
	}

	public ApiErrorsDTO(String message, String errors, HttpStatus status) {
		this.message = message;
		this.errors = Arrays.asList(errors);
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
