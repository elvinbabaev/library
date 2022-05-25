package com.babaev.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_booking")
public class Booking {

	@EmbeddedId
	private BookingKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "book_id")
	private Book book;

	private OffsetDateTime bookingDate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Booking booking = (Booking) o;
		return id != null && Objects.equals(id, booking.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
