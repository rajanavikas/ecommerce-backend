package com.example.salesOrder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.salesOrder.Dto.ItemNameDto;
import com.example.salesOrder.model.OrderLineItem;

@Repository
public interface SalesOrderLineItemRepository extends JpaRepository<OrderLineItem, Integer>  
{
	@Query("select new com.example.salesOrder.Dto.ItemNameDto (c.orderName) from OrderLineItem as c where c.orderId=?1")
	List<ItemNameDto> getOrderItems(Integer orderId);
}
