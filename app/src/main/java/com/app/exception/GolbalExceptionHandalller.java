package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GolbalExceptionHandalller {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDeatils> StudentExceptionHandler(StudentException doctorExp, WebRequest req) {
		
		MyErrorDeatils error = new MyErrorDeatils(LocalDateTime.now(), doctorExp.getMessage(), req.getDescription(false));
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(doctorExp.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDeatils>(error, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(MarkException.class)
	public ResponseEntity<MyErrorDeatils> MarkExceptionHandaller(MarkException nfe, WebRequest req) {

		MyErrorDeatils error = new MyErrorDeatils();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(nfe.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDeatils>(error, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDeatils> ExceptionHandler(Exception doctorExp, WebRequest req) {
		
		MyErrorDeatils error = new MyErrorDeatils(LocalDateTime.now(), doctorExp.getMessage(), req.getDescription(false));
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(doctorExp.getMessage());
		error.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDeatils>(error, HttpStatus.BAD_REQUEST);

	}
}
