package com.babaev.library.model.dto;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
@Builder
public class ResponseMsg {
	Long code;
	String message;
	OffsetDateTime date;
}
