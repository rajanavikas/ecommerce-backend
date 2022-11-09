package com.example.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/check/customer/{custId}")
	public boolean checkCustomer(@PathVariable("custId") int custId) {
		System.out.println(customerService.checkCustomer(custId));
		Optional<Customer> c1 = customerService.checkCustomer(custId);
		if (c1.isEmpty()) {
			return false;
		}
		return true;
	}

	@GetMapping("/getCustomer/{custEmail}")
	public Integer getCustomer(@PathVariable String custEmail) {

		return customerService.getCustomerIdService(custEmail);
	}

	@GetMapping("/customers")
	public ResponseEntity<Optional<List<Customer>>> getCustomers() {
		Optional<List<Customer>> customers = customerService.getCustomersService();
		return Optional.of(customers).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
	}

	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomerService(customer);
	}
}