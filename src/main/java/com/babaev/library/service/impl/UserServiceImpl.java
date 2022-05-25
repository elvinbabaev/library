package com.babaev.library.service.impl;

import com.babaev.library.mapper.UserMapper;
import com.babaev.library.model.dto.UserRs;
import com.babaev.library.repository.UserRepository;
import com.babaev.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public Page<UserRs> find(Pageable pageable) {
		return userMapper.toRs(userRepository.findAll(pageable));
	}
}
