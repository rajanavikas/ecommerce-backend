package com.example.items.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.items.model.Items;

@Repository
public interface ItemRepo extends JpaRepository<Items,Integer> {
	
	@Query(value = "select name,price,description from Items i where i.name=?1")
	String getIndividualItemByName(String itemName);
	
	@Query(value="select description from Items as c where c.name=?1")
	String checkItem(String itemName);
}
