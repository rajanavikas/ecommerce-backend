package com.example.salesOrder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service", url = "${ITEM.URL}")
public interface ItemClient {
	@GetMapping(value = "/check/item/{Itemname}")
    public boolean checkItem(@PathVariable("Itemname") String Itemname);
}


