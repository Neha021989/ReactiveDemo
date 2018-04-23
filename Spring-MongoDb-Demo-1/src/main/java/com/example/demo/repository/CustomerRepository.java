package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Customer;
import com.example.demo.model.QCustomer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>,QuerydslPredicateExecutor<Customer>,QuerydslBinderCustomizer<QCustomer> {

	 @Override
	  default public void customize(QuerydslBindings bindings, QCustomer customer) {

	    bindings.bind(customer.customerName).first((path, value) -> path.containsIgnoreCase(value));    
	    bindings.bind(customer.customerAddress).first((path, value) -> path.containsIgnoreCase(value));                                 
	  }
}
