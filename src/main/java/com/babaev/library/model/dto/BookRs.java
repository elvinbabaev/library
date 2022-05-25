package com.babaev.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRs {
	private Long id;
	private String title;
	private String author;
	private OffsetDateTime releaseDate;
	private Set<BookingRs> bookings;
}
