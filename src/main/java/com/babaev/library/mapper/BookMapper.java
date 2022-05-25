package com.babaev.library.mapper;

import com.babaev.library.model.dto.BookRs;
import com.babaev.library.model.dto.BookingRs;
import com.babaev.library.model.entity.Book;
import com.babaev.library.model.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.Set;

@Mapper
public interface BookMapper {

	@Mapping(target = "login", expression = "java(booking.getUser().getLogin())")
	@Mapping(target = "author", ignore = true)
	@Mapping(target = "title", ignore = true)
	@Mapping(target = "bookingDate", source = "bookingDate")
	BookingRs toShortBookingRs(Booking booking);

	Set<BookingRs> toShortBookingRs(Set<Booking> bookings);

	@Mapping(target = "author", expression = "java(book.getAuthor().getName())")
	BookRs toRs(Book book);

	default Page<BookRs> toRs(Page<Book> books) {
		return books.map(this::toRs);
	}
}
