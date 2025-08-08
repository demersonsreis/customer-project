package com.aplinno.customerapp.adapter.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aplinno.customerapp.adapter.persistence.entity.CustomerEntity;
import com.aplinno.customerapp.adapter.persistence.mapper.CustomerMapper;
import com.aplinno.customerapp.adapter.persistence.repository.CustomerJpaRepository;
import com.aplinno.customerapp.domain.model.Address;
import com.aplinno.customerapp.domain.model.Contact;
import com.aplinno.customerapp.domain.model.Customer;
import com.aplinno.customerapp.port.out.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerJpaAdapter implements CustomerRepository {
    @Autowired
    private   CustomerJpaRepository customerJpaRepository;
    @Autowired
    private   CustomerMapper customerMapper;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        CustomerEntity entity = customerMapper.toEntity(customer);
        CustomerEntity savedEntity = customerJpaRepository.save(entity);
        return customerMapper.toDomain(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(String id) {
        return customerJpaRepository.findById(UUID.fromString(id))
                .map(customerMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return customerJpaRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public void updateAddress(String customerId, Address address) {
        CustomerEntity customer = customerJpaRepository.findById(UUID.fromString(customerId))
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        
        customer.setAddress(customerMapper.toAddressEntity(address));
        customerJpaRepository.save(customer);
    }

    @Override
    @Transactional
    public void updateContact(String customerId, Contact contact) {
        CustomerEntity customer = customerJpaRepository.findById(UUID.fromString(customerId))
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        
        customer.setContact(customerMapper.toContactEntity(contact));
        customerJpaRepository.save(customer);
    }
}