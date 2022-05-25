package com.babaev.library.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_author")
public class Author {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "author")
	@ToString.Exclude
	private Set<Book> books;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Author author = (Author) o;
		return id != null && Objects.equals(id, author.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
