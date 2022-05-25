package com.babaev.library.service;

import com.babaev.library.model.dto.AuthorRs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

	Page<AuthorRs> find(Pageable pageable);
}
