package com.babaev.library.service;

import com.babaev.library.model.dto.UserRs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	Page<UserRs> find(Pageable pageable);
}
