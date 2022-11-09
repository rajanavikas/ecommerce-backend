package com.example.salesOrder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.salesOrder.Dto.ItemNameDto;
import com.example.salesOrder.Dto.OrderDto;
import com.example.salesOrder.model.SalesOrder;



public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> 
{
@Query("select new com.example.salesOrder.Dto.OrderDto (c.orderId,c.orderDescription) from SalesOrder as c where c.custId=?1")
List<OrderDto> getAllOrders(Integer custId);

@Query("select new com.example.salesOrder.Dto.ItemNameDto (c.orderDescription) from SalesOrder as c where c.orderId=?1")
ItemNameDto getOrderDesc(Integer orderId);



}
