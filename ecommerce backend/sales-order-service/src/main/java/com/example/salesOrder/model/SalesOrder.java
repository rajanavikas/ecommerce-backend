package com.example.salesOrder.model;

import java.sql.Date;
import java.util.List;

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
public class SalesOrder 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
private int custId;
private int orderId;
private String orderDescription;
private Date orderDate;
private int totalPrice;
}
