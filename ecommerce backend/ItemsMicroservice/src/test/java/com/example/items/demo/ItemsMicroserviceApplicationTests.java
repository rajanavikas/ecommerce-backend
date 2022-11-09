package com.example.items.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.items.model.Items;
import com.example.items.repository.ItemRepo;

@SpringBootTest
class ItemsMicroserviceApplicationTests {

	@Autowired
	ItemRepo itemRepo;
	
	private Items items;
	private String name;
	private String description;
	private int price;
	private int id;
	@BeforeEach
	void init()
	{
		id=1;
		name="oneplus";
		description="nice smartphone brand";
		price=34500;
		items=new Items(id,name,description,price);
	}
	@Test
	void testsaveItem()
	{
		assertEquals(items,itemRepo.save(items));
	}
	@Test
	void testgetAllItems()
	{
		itemRepo.save(items);
		//Positive Case
		assertTrue(itemRepo.findAll().size()>0);
	}
	@Test
	void testGetItem()
	{
		//Positive Cases
		assertEquals("oneplus,34500,nice smartphone brand",itemRepo.getIndividualItemByName("oneplus"));
		//Negative Cases
		assertNotEquals("mob",itemRepo.getIndividualItemByName("mobile"));
	}

}
