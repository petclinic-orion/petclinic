package org.springframework.samples.petclinic.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		String htmlResponse = generateHtmlResponse("Invalid Operation", ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now());
		return new ResponseEntity<>(htmlResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult()
			.getFieldErrors()
			.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		String htmlResponse = generateHtmlResponse("Validation Failed", errors.toString(),
				HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
		return new ResponseEntity<>(htmlResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {
		String htmlResponse = generateHtmlResponse("Unexpected Error", ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
		return new ResponseEntity<>(htmlResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String generateHtmlResponse(String title, String message, int status, LocalDateTime timestamp) {
		return "<html>" + "<head>" + "<style>" + "body { font-family: Arial, sans-serif; margin: 0; padding: 20px; }"
				+ ".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px; background-color: #f9f9f9; }"
				+ ".title { color: #e74c3c; font-size: 24px; margin-bottom: 20px; }"
				+ ".message { font-size: 18px; margin-bottom: 10px; }"
				+ ".details { color: #555; font-size: 14px; margin-top: 10px; }" + "</style>" + "</head>" + "<body>"
				+ "<div class='container'>" + "<div class='title'>" + title + "</div>" + "<div class='message'>"
				+ message + "</div>" + "<div class='details'>" + "<strong>Status:</strong> " + status + "<br>"
				+ "<strong>Timestamp:</strong> " + timestamp + "</div>" + "</div>" + "</body>" + "</html>";
	}

}
