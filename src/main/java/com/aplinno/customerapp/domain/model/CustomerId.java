package com.aplinno.customerapp.domain.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CustomerId {
    private final UUID value;

    public CustomerId(UUID value) {
        this.value = value;
    }

    public static CustomerId generate() {
        return new CustomerId(UUID.randomUUID());
    }

	public UUID getValue() {
		return value;
	}
    
    
}