package com.babaev.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BookingKey implements Serializable {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "book_id")
	private Long bookId;
}
