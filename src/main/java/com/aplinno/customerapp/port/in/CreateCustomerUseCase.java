package com.aplinno.customerapp.port.in;

import com.aplinno.customerapp.domain.model.Customer;

public interface CreateCustomerUseCase {

	Customer createCustomer(CreateCustomerCommand command);
	 
	public record CreateCustomerCommand(
		    String name,
		    String email,
		    AddressCommand address,
		    ContactCommand contact
		) {
		    public record AddressCommand(
		        String street,
		        String number,
		        String complement,
		        String neighborhood,
		        String city,
		        String state,
		        String zipCode
		    ) {}

		    public record ContactCommand(
		        String phone,
		        String mobile
		    ) {}
		}

}