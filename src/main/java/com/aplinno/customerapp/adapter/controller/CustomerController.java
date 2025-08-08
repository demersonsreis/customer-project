package com.aplinno.customerapp.adapter.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aplinno.customerapp.domain.model.Customer;
import com.aplinno.customerapp.port.in.CreateCustomerUseCase;
import com.aplinno.customerapp.port.in.UpdateAddressUseCase;
import com.aplinno.customerapp.port.in.UpdateContactUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private   CreateCustomerUseCase createCustomerUseCase;
    private   UpdateAddressUseCase updateAddressUseCase;
    private   UpdateContactUseCase updateContactUseCase;
    
  
    public CustomerController(CreateCustomerUseCase createCustomerUseCase, UpdateAddressUseCase updateAddressUseCase,
			UpdateContactUseCase updateContactUseCase) {
		this.createCustomerUseCase = createCustomerUseCase;
		this.updateAddressUseCase = updateAddressUseCase;
		this.updateContactUseCase = updateContactUseCase;
	}

	@PostMapping
    public ResponseEntity<Customer> createCustomer(
            @RequestBody CreateCustomerUseCase.CreateCustomerCommand command) {
        
        Customer customer = createCustomerUseCase.createCustomer(command);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId().getValue())
                .toUri();
        
        return ResponseEntity.created(location).body(customer);
    }

    @PatchMapping("/{customerId}/address")
    public ResponseEntity<Void> updateAddress(
            @PathVariable String customerId,
            @RequestBody UpdateAddressUseCase.UpdateAddressCommand command) {
        
        updateAddressUseCase.updateAddress(customerId, command);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{customerId}/contact")
    public ResponseEntity<Void> updateContact(
            @PathVariable String customerId,
            @RequestBody UpdateContactUseCase.UpdateContactCommand command) {
        
        updateContactUseCase.updateContact(customerId, command);
        return ResponseEntity.noContent().build();
    }
}