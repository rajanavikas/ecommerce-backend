package com.example.salesOrder.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salesOrder.Dto.CreateOrderDto;
import com.example.salesOrder.Dto.ItemNameDto;
import com.example.salesOrder.Dto.OrderDto;
import com.example.salesOrder.Dto.SalesOrderDto;
import com.example.salesOrder.Repository.SalesOrderLineItemRepository;
import com.example.salesOrder.Repository.SalesOrderRepository;
import com.example.salesOrder.model.OrderLineItem;
import com.example.salesOrder.model.SalesOrder;

@Service
public class SalesOrderService {
	private SalesOrderRepository salesOrderRepository;
	private SalesOrderLineItemRepository salesOrderLineItemRepository;

	@Autowired
	public SalesOrderService(SalesOrderRepository salesOrderRepository,
			SalesOrderLineItemRepository salesOrderLineItemRepository) {
		this.salesOrderRepository = salesOrderRepository;
		this.salesOrderLineItemRepository = salesOrderLineItemRepository;
	}

	public SalesOrderDto createOrderService(CreateOrderDto createOrderDto) {
		Random rd = new Random();
		SalesOrder resOrder = new SalesOrder();
		int generatedOrderId=rd.nextInt(99987);
		resOrder.setCustId(createOrderDto.getCustId());
		resOrder.setOrderDate(createOrderDto.getOrderDate());
		resOrder.setOrderDescription(createOrderDto.getOrderDescription());
		resOrder.setOrderId(generatedOrderId);
		resOrder.setTotalPrice(970);
		SalesOrder saveOrder = salesOrderRepository.save(resOrder);

		for (int i = 0; i < createOrderDto.getItemsList().size(); i++) {
			OrderLineItem orderLineItem = new OrderLineItem();
			orderLineItem.setItemQty(2);
			orderLineItem.setOrderId(generatedOrderId);
			orderLineItem.setOrderName(createOrderDto.getItemsList().get(i));
			OrderLineItem resItem = salesOrderLineItemRepository.save(orderLineItem);
		}

		SalesOrderDto salesOrderDto = new SalesOrderDto();
		salesOrderDto.setOrderDescription(saveOrder.getOrderDescription());
		salesOrderDto.setOrderId(saveOrder.getOrderId());
		salesOrderDto.setItemNames(createOrderDto.getItemsList());
		return salesOrderDto;

	}

	public List<OrderDto> getAllOrdersService(Integer customerId) {
		List<OrderDto> orderDtoList = salesOrderRepository.getAllOrders(customerId);
		return orderDtoList;
	}

	public SalesOrderDto getOrderDetailsService(Integer orderId) {
		String orderDescription = salesOrderRepository.getOrderDesc(orderId).getItemName();
		List<ItemNameDto> orderItems = salesOrderLineItemRepository.getOrderItems(orderId);
		List<String> items=orderItems.stream().map((x)->x.getItemName()).collect(Collectors.toList());
		SalesOrderDto salesOrderDto = new SalesOrderDto();
		salesOrderDto.setOrderId(orderId);
		salesOrderDto.setOrderDescription(orderDescription);
		salesOrderDto.setItemNames(items);

		return salesOrderDto;
	}
	

}
