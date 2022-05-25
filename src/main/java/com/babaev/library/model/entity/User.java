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
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	private String login;

	private String password;

	private OffsetDateTime registrationDate;

	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private Set<Booking> bookings;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
