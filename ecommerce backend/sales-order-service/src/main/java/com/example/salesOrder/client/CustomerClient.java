package com.example.salesOrder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service", url = "${CUSTOMER.URL}")
public interface CustomerClient {
	@GetMapping(value = "/check/customer/{custId}")
    public boolean checkCustomer(@PathVariable("custId") int custId);
	
	@GetMapping("/getCustomer/{custEmail}")
	public Integer getCustomer(@PathVariable String custEmail);
}
