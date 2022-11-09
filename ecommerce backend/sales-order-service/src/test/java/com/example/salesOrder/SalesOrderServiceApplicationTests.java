package com.example.salesOrder;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.salesOrder.Repository.SalesOrderLineItemRepository;
import com.example.salesOrder.Repository.SalesOrderRepository;
import com.example.salesOrder.model.OrderLineItem;
import com.example.salesOrder.model.SalesOrder;

@SpringBootTest
class SalesOrderServiceApplicationTests {
	
	private SalesOrderRepository salesOrderRepository;
	private SalesOrderLineItemRepository salesOrderLineItemRepository;

	@Autowired
	public SalesOrderServiceApplicationTests(SalesOrderRepository salesOrderRepository,
			SalesOrderLineItemRepository salesOrderLineItemRepository) {
		this.salesOrderRepository = salesOrderRepository;
		this.salesOrderLineItemRepository = salesOrderLineItemRepository;
	}

	@Test
	public void testCreateOrder()
	{
		//Random rd = new Random();
		SalesOrder resOrder = new SalesOrder();
		//int generatedOrderId=rd.nextInt(99987);
		resOrder.setCustId(10);
		resOrder.setOrderDate(Date.valueOf("2022-09-10"));
		resOrder.setOrderDescription("Sample Description");
		resOrder.setOrderId(3698);
		resOrder.setTotalPrice(970);
		assertNotNull(salesOrderRepository.save(resOrder));
		
		OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setItemQty(2);
		orderLineItem.setOrderId(3698);
		orderLineItem.setOrderName("mobile");
		assertNotNull(salesOrderLineItemRepository.save(orderLineItem));
	}
	@Test
	public void testGetAllOrders()
	{
		//Positive Case
		assertTrue(salesOrderRepository.getAllOrders(10).size()>0);
		//Negative Cases
		assertTrue(salesOrderRepository.getAllOrders(1).size()==0);
		assertTrue(salesOrderRepository.getAllOrders(2).size()==0);
		assertTrue(salesOrderRepository.getAllOrders(90).size()==0);
		
	}
	
	@Test
	public void testGetOrderDetails()
	{
		//Positive Case
		assertTrue(salesOrderLineItemRepository.getOrderItems(3698).size()>0);
		//Negative Cases
		assertTrue(salesOrderLineItemRepository.getOrderItems(4500).size()==0);
		assertTrue(salesOrderLineItemRepository.getOrderItems(103).size()==0);
		assertTrue(salesOrderLineItemRepository.getOrderItems(3569).size()==0);
	}

}
