package com.example.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {
@Autowired
private CustomerRepository customerRepository;

public Optional<Customer> checkCustomer(int custId) {
	return customerRepository.findById(custId);
}

public Integer  getCustomerIdService(String email)
{
	return customerRepository.getCustomerId(email);
}

public Optional<List<Customer>> getCustomersService()
{
	return Optional.of(customerRepository.findAll());
}
public Customer saveCustomerService(Customer customer)
{
	return customerRepository.save(customer);
}
}
