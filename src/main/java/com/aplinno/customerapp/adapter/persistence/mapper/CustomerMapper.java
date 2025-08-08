package com.aplinno.customerapp.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.aplinno.customerapp.adapter.persistence.entity.AddressEntity;
import com.aplinno.customerapp.adapter.persistence.entity.ContactEntity;
import com.aplinno.customerapp.adapter.persistence.entity.CustomerEntity;
import com.aplinno.customerapp.domain.model.Address;
import com.aplinno.customerapp.domain.model.Contact;
import com.aplinno.customerapp.domain.model.Customer;
import com.aplinno.customerapp.domain.model.CustomerId;
import com.aplinno.customerapp.domain.model.Email;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getId().getValue(),
                customer.getName(),
                customer.getEmail().getValue(),
                toAddressEntity(customer.getAddress()),
                toContactEntity(customer.getContact()),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }

    public Customer toDomain(CustomerEntity entity) {
        return new Customer(
                new CustomerId(entity.getId()),
                entity.getName(),
                new Email(entity.getEmail()),
                toAddress(entity.getAddress()),
                toContact(entity.getContact()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public AddressEntity toAddressEntity(Address address) {
        return new AddressEntity(
                address.getId().getValue(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getZipCode()
        );
    }

    public Address toAddress(AddressEntity entity) {
        return new Address(
                entity.getStreet(),
                entity.getNumber(),
                entity.getComplement(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getZipCode()
        );
    }

    public ContactEntity toContactEntity(Contact contact) {
        return new ContactEntity(
                contact.getId().getValue(),
                contact.getPhone(),
                contact.getMobile()
        );
    }

    public Contact toContact(ContactEntity entity) {
        return new Contact(
                entity.getPhone(),
                entity.getMobile()
        );
    }
}