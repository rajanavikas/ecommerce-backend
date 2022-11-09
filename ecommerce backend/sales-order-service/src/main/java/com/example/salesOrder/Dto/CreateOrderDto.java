package com.example.salesOrder.Dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDto 
{
	private int custId;
	private List<String> itemsList;
	private String orderDescription;
	private Date orderDate;
	@JsonCreator
	public CreateOrderDto(List<String> itemsList) {
	    this.itemsList = itemsList;
	}
}
