package org.springframework.samples.petclinic.advice;

import java.time.LocalDateTime;

public class ExceptionResponse {

	private String error;

	private String message;

	private int status;

	private LocalDateTime timestamp;

	// Constructors
	public ExceptionResponse() {
	}

	public ExceptionResponse(String error, String message, int status, LocalDateTime timestamp) {
		this.error = error;
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	// Getters and Setters

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
