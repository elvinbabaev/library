package com.babaev.library.utils;

import org.springframework.http.HttpStatus;

public class Constants {

	public static final String BOOKING_IS_VALID = "бронь еще действительна до %s";
	public static final String MAX_BOOKING = "достигнуто максимальное кол-во броней";
	public static final String REVERVED = "данная книга забронирована";

	public static final Long BAD_REQUEST_CODE = (long) HttpStatus.BAD_REQUEST.value();
	public static final Long NOT_FOUND_CODE = (long) HttpStatus.NOT_FOUND.value();
}
