package com.example.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer 
{
@Id
@Column(name="id")
//@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="email")
private String email;
@Column(name="firstName")
private String firstName;
@Column(name="lastName")
private String lastName;
}
