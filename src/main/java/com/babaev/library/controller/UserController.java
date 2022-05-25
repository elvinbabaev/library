package com.babaev.library.controller;

import com.babaev.library.model.dto.UserRs;
import com.babaev.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	@GetMapping
	public Page<UserRs> find(Pageable pageable) {
		return userService.find(pageable);
	}
}
