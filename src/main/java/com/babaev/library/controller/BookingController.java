package com.babaev.library.controller;

import com.babaev.library.model.dto.BookingRq;
import com.babaev.library.model.dto.BookingRs;
import com.babaev.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

	private final BookingService bookingService;

	@PostMapping
	public BookingRs booking(@RequestBody BookingRq bookingRq) {
		return bookingService.booking(bookingRq);
	}

	@GetMapping
	public Page<BookingRs> find(Pageable pageable, @RequestParam Long userId) {
		return bookingService.find(pageable, userId);
	}
}
