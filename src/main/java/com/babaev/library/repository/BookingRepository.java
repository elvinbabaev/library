package com.babaev.library.repository;

import com.babaev.library.model.entity.Booking;
import com.babaev.library.model.entity.BookingKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.OffsetDateTime;

public interface BookingRepository extends PagingAndSortingRepository<Booking, BookingKey> {

	Page<Booking> findAllByUser_IdEquals(Pageable pageable, Long id);

	void deleteByBookingDateBefore(OffsetDateTime dateTime);

	Long countBookingByUser_IdEquals(Long id);

	boolean existsByBook_IdEquals(Long id);
}
