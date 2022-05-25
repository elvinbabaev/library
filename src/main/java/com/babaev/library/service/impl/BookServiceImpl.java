package com.babaev.library.service.impl;

import com.babaev.library.mapper.BookMapper;
import com.babaev.library.model.dto.BookRs;
import com.babaev.library.repository.BookRepository;
import com.babaev.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	@Override
	@Transactional
	public Page<BookRs> find(Pageable pageable, String author) {
		if (Objects.isNull(author))
			return bookMapper.toRs(bookRepository.findAll(pageable));
		else {
			return bookMapper.toRs(bookRepository.findByAuthor_NameEquals(pageable, author));
		}
	}
}
