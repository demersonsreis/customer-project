package com.aplinno.customerapp.domain.model;
 
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AddressId {
    private final UUID value;

    public AddressId(UUID value) {
        this.value = value;
    }

    public static AddressId generate() {
        return new AddressId(UUID.randomUUID());
    }
    
    public UUID getValue() {
		return value;
	}
}