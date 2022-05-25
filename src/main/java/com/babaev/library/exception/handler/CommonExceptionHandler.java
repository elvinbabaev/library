package com.babaev.library.exception.handler;

import com.babaev.library.exception.BookingException;
import com.babaev.library.model.dto.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

import static com.babaev.library.utils.Constants.BAD_REQUEST_CODE;
import static com.babaev.library.utils.Constants.NOT_FOUND_CODE;

@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(BookingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMsg handlerBookingException(BookingException exception) {
		return ResponseMsg.builder()
				.code(BAD_REQUEST_CODE)
				.message(exception.getMessage())
				.date(OffsetDateTime.now())
				.build();

	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseMsg handlerNoSuchElementException(NoSuchElementException exception) {
		return ResponseMsg.builder()
				.code(NOT_FOUND_CODE)
				.message(exception.getMessage())
				.date(OffsetDateTime.now())
				.build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMsg handlerException(Exception exception) {
		return ResponseMsg.builder()
				.code(BAD_REQUEST_CODE)
				.message(exception.getMessage())
				.date(OffsetDateTime.now())
				.build();
	}
}
