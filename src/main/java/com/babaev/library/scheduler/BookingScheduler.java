package com.babaev.library.scheduler;

import com.babaev.library.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingScheduler {

	private final BookingService bookingService;

	@Scheduled(fixedDelay = 1000 * 60)
	public void deleteByExpirationDate() {
		bookingService.deleteByExpirationDate();
		log.info("Удалены истекшие брони");
	}
}
