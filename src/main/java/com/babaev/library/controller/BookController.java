package com.babaev.library.controller;

import com.babaev.library.model.dto.BookRs;
import com.babaev.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	@GetMapping
	public Page<BookRs> findBooks(Pageable pageable, @RequestParam(required = false) String author) {
		return bookService.find(pageable, author);
	}
}
