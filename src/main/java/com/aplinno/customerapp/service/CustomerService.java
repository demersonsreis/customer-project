package com.aplinno.customerapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplinno.customerapp.domain.model.Address;
import com.aplinno.customerapp.domain.model.Contact;
import com.aplinno.customerapp.domain.model.Customer;
import com.aplinno.customerapp.port.in.CreateCustomerUseCase;
import com.aplinno.customerapp.port.in.UpdateAddressUseCase;
import com.aplinno.customerapp.port.in.UpdateContactUseCase;
import com.aplinno.customerapp.port.out.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements 
    CreateCustomerUseCase,
    UpdateAddressUseCase,
    UpdateContactUseCase {

    private final CustomerRepository customerRepository;
  
    public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
    @Transactional
    public Customer createCustomer(CreateCustomerCommand command) {
        if (customerRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("Email already in use");
        }
        
        Address address = new Address(
            command.address().street(),
            command.address().number(),
            command.address().complement(),
            command.address().neighborhood(),
            command.address().city(),
            command.address().state(),
            command.address().zipCode()
        );
        
        Contact contact = new Contact(
            command.contact().phone(),
            command.contact().mobile()
        );
        
        Customer customer = Customer.create(
            command.name(),
            command.email(),
            address,
            contact
        );
        
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void updateAddress(String customerId, UpdateAddressCommand command) {
        Address newAddress = new Address(
            command.street(),
            command.number(),
            command.complement(),
            command.neighborhood(),
            command.city(),
            command.state(),
            command.zipCode()
        );
        
        customerRepository.updateAddress(customerId, newAddress);
    }

    @Override
    @Transactional
    public void updateContact(String customerId, UpdateContactCommand command) {
        Contact newContact = new Contact(
            command.phone(),
            command.mobile()
        );
        
        customerRepository.updateContact(customerId, newContact);
    }
}