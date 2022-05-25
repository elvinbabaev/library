package com.babaev.library.service;

import com.babaev.library.model.dto.BookRs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

	Page<BookRs> find(Pageable pageable, String author);
}
