package com.babaev.library.service.impl;

import com.babaev.library.mapper.AuthorMapper;
import com.babaev.library.model.dto.AuthorRs;
import com.babaev.library.repository.AuthorRepository;
import com.babaev.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	private final AuthorMapper authorMapper;

	@Override
	public Page<AuthorRs> find(Pageable pageable) {
		return authorMapper.toRs(authorRepository.findAll(pageable));
	}
}
