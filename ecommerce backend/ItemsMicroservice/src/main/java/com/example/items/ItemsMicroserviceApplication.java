package com.example.items;

//import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.items.model.Items;
import com.example.items.repository.ItemRepo;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.items")
@EnableDiscoveryClient
@EnableSwagger2
public class ItemsMicroserviceApplication //implements CommandLineRunner 
{

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ItemsMicroserviceApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
	Items item1=new Items(1,"mobile","jdbldsnk",10000); 
	Items item2=new Items(2,"laptop","jdbldsnk",10000); 
	Items item3=new Items(3,"calculator","jdbldsnk",10000); 
	Items item4=new Items(4,"Pen","Sample",10); 
	ArrayList<Items> item=new ArrayList<Items>();
	item.add(item1);
	item.add(item2);
	item.add(item3);
	
	itemrepo.saveAll(item);
	}*/



@Bean
public Docket productApi() {
   return new Docket(DocumentationType.SWAGGER_2).select()
      .apis(RequestHandlerSelectors.basePackage("com.example.items")).build();
}

}
