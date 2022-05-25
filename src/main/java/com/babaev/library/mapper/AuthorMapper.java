package com.babaev.library.mapper;

import com.babaev.library.model.dto.AuthorRs;
import com.babaev.library.model.entity.Author;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface AuthorMapper {

	AuthorRs toRs(Author author);

	default Page<AuthorRs> toRs(Page<Author> authors) {
		return authors.map(this::toRs);
	}
}
