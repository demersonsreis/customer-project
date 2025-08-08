package com.aplinno.customerapp.port.in;


public interface UpdateAddressUseCase {
    void updateAddress(String customerId, UpdateAddressCommand command);
    
    record UpdateAddressCommand(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String zipCode
    ) {}
}