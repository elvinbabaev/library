package com.babaev.library.mapper;

import com.babaev.library.model.dto.BookingRs;
import com.babaev.library.model.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper
public interface BookingMapper {

	@Mapping(target = "login", expression = "java(booking.getUser().getLogin())")
	@Mapping(target = "author", expression = "java(booking.getBook().getAuthor().getName())")
	@Mapping(target = "title", expression = "java(booking.getBook().getTitle())")
	@Mapping(target = "bookingDate", source = "bookingDate")
	BookingRs toRs(Booking booking);

	default Page<BookingRs> toRs(Page<Booking> bookings) {
		return bookings.map(this::toRs);
	}
}
