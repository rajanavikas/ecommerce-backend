package com.example.salesOrder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int orderId;
private String orderName;
private int itemQty;
}
