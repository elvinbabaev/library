package com.babaev.library.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_book")
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	private OffsetDateTime releaseDate;

	@OneToMany(mappedBy = "book")
	@ToString.Exclude
	private Set<Booking> bookings;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Book book = (Book) o;
		return id != null && Objects.equals(id, book.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
