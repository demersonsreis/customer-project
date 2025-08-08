package com.aplinno.customerapp.port.out;

import java.util.Optional;

import com.aplinno.customerapp.domain.model.Address;
import com.aplinno.customerapp.domain.model.Contact;
import com.aplinno.customerapp.domain.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(String id);
    boolean existsByEmail(String email);
    

    void updateAddress(String customerId, Address address);
    void updateContact(String customerId, Contact contact);
}