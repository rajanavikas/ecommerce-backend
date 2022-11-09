package com.example.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test 
	void testCreateCustomer()
	{
		Customer c=new Customer();
		c.setId(101);
		c.setEmail("coder@gmail.com");
		c.setFirstName("Ted");
		c.setLastName("Mosby");
		customerRepository.save(c);
		//Positive Cases
		assertTrue(customerRepository.findById(c.getId()).isPresent());
		c.setId(305);
		customerRepository.save(c);
		assertTrue(customerRepository.findById(c.getId()).isPresent());
		
		//Negative cases
		assertTrue(customerRepository.findById(10).isEmpty());
		assertTrue(customerRepository.findById(90).isEmpty());
	}
    @Test
	void testgetAllCustomers()
	{
    	List<Customer> custList=customerRepository.findAll();
		assertTrue(custList.size()>0);
	}

}
