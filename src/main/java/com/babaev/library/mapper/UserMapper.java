package com.babaev.library.mapper;

import com.babaev.library.model.dto.UserRs;
import com.babaev.library.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface UserMapper {

	UserRs toRs(User user);

	default Page<UserRs> toRs(Page<User> users) {
		return users.map(this::toRs);
	}
}
