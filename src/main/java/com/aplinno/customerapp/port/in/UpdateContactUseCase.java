package com.aplinno.customerapp.port.in;

 
public interface UpdateContactUseCase {
    void updateContact(String customerId, UpdateContactCommand command);
    
    record UpdateContactCommand(
        String phone,
        String mobile
    ) {}
}