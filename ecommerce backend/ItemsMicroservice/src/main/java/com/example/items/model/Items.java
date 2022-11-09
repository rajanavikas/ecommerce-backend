package com.example.items.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Items")
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Items {
	private int id;
	@Id
	private String name;
	private String description;
	private int price;
}
