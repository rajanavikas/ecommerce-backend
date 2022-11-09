package com.example.salesOrder.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@JsonProperty
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderDto 
{
private int orderId;
private String orderDescription;
private List<String> itemNames;
//private ItemListDto itemNames;
}
