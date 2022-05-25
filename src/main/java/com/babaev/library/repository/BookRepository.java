package com.babaev.library.repository;

import com.babaev.library.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	Page<Book> findByAuthor_NameEquals(Pageable pageable, String author);
}
