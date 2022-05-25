package com.babaev.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingRs {
	private String login;
	private String author;
	private String title;
	private OffsetDateTime bookingDate;
}
