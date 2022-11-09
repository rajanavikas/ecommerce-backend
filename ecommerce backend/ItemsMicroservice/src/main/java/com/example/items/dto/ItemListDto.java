package com.example.items.dto;

import java.util.List;

import com.example.items.model.Items;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ItemListDto {

	@JsonCreator
	public ItemListDto(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	private List<Items> itemsList;
}
