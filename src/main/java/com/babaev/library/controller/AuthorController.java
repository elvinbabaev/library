package com.babaev.library.controller;

import com.babaev.library.model.dto.AuthorRs;
import com.babaev.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

	private final AuthorService authorService;

	@GetMapping
	public Page<AuthorRs> findAuthors(Pageable pageable) {
		return authorService.find(pageable);
	}
}
