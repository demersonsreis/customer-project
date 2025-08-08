package com.aplinno.customerapp.domain.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ContactId {
	private final UUID value;

	public ContactId(UUID value) {
		this.value = value;
	}

	public static ContactId generate() {
		return new ContactId(UUID.randomUUID());
	}

	public UUID getValue() {
		return value;
	}
	
	
}