package com.example.salesOrder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.salesOrder.model.CustomerSOS;

@Repository
public interface SalesOrderCustomerRepository extends JpaRepository<CustomerSOS, Integer> 
{

}
