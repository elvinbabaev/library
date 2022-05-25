package com.babaev.library.service.impl;

import com.babaev.library.exception.BookingException;
import com.babaev.library.mapper.BookingMapper;
import com.babaev.library.model.dto.BookingRq;
import com.babaev.library.model.dto.BookingRs;
import com.babaev.library.model.entity.Book;
import com.babaev.library.model.entity.Booking;
import com.babaev.library.model.entity.BookingKey;
import com.babaev.library.model.entity.User;
import com.babaev.library.repository.BookRepository;
import com.babaev.library.repository.BookingRepository;
import com.babaev.library.repository.UserRepository;
import com.babaev.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

import static com.babaev.library.utils.Constants.*;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

	private final BookingRepository bookingRepository;
	private final BookingMapper bookingMapper;

	private final BookRepository bookRepository;

	private final UserRepository userRepository;

	@Value("${maximum.bookings}")
	private Long maximumBookings;

	@Override
	public BookingRs booking(BookingRq bookingRq) {
		BookingKey key = createKey(bookingRq);
		bookingRepository.findById(key).ifPresent(booking -> {
			throw new BookingException(String.format(BOOKING_IS_VALID, booking.getBookingDate().toString()));
		});
		if (bookingRepository.countBookingByUser_IdEquals(key.getUserId()) >= maximumBookings) {
			throw new BookingException(MAX_BOOKING);
		}
		if (bookingRepository.existsByBook_IdEquals(key.getBookId())) {
			throw new BookingException(REVERVED);
		}
		Booking booking = bookingRepository.save(create(key));
		return bookingMapper.toRs(booking);
	}

	@Override
	public Page<BookingRs> find(Pageable pageable, Long userId) {
		return bookingMapper.toRs(bookingRepository.findAllByUser_IdEquals(pageable, userId));
	}

	@Transactional
	public void deleteByExpirationDate() {
		bookingRepository.deleteByBookingDateBefore(OffsetDateTime.now());
	}

	private Booking create(BookingKey key) {
		Book book = bookRepository.findById(key.getBookId()).orElseThrow();
		User user = userRepository.findById(key.getUserId()).orElseThrow();
		return new Booking(key, user, book, OffsetDateTime.now().plusHours(1));
	}

	private BookingKey createKey(BookingRq bookingRq) {
		return new BookingKey(bookingRq.getUserId(), bookingRq.getBookId());
	}
}
