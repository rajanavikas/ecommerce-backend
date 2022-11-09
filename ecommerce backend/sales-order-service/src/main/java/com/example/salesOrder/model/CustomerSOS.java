package com.example.salesOrder.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class CustomerSOS 
{
@Id
@Column(name="custId")
private int custId;
@Column(name="custEmail")
private String custEmail;
@Column(name="custFirstName")
private String custFirstName;
@Column(name="custLastName")
private String custLastName;
}
