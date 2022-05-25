package com.babaev.library.service;

import com.babaev.library.model.dto.BookingRq;
import com.babaev.library.model.dto.BookingRs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
	BookingRs booking(BookingRq bookingRq);

	Page<BookingRs> find(Pageable pageable, Long userId);

	void deleteByExpirationDate();
}
