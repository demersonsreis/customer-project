package com.aplinno.customerapp.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Customer {
	private CustomerId id;
	private String name;
	private Email email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Address address; // Agora é uma referência
	private Contact contact;

	 
	public Customer(CustomerId id, String name, Email email, Address address, Contact contact, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.address = address;
		this.contact = contact;
	}

	public static Customer create(String name, String email, Address address, Contact contact) {
		return new Customer(CustomerId.generate(), name, new Email(email), address, contact, LocalDateTime.now(),
				LocalDateTime.now());
	}

	public void update(String name, String email) {
		this.name = name;
		this.email = new Email(email);
		this.updatedAt = LocalDateTime.now();
	}

	public CustomerId getId() {
		return id;
	}

	public void setId(CustomerId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}