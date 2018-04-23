package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Order;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.querydsl.core.types.Predicate;

@RestController
//@RequestMapping("/custOrders")
public class CustomerOrderController {

	private CustomerRepository customerRepository;
	private OrderRepository orderRepository;
	@Autowired
	public CustomerOrderController(CustomerRepository customerRepository,OrderRepository orderRepository)
	{
		this.customerRepository=customerRepository;
		this.orderRepository=orderRepository;
	}
	@RequestMapping(value = "/")
	public String home() {
		return "Okay!";
	}
	
	@GetMapping("/customer/{custId}/orders")
	public Iterable<Order> getAllOrdersforCustomer(@PathVariable String custId)
	{
		System.out.println("Inside Method getAllOrdersforCustomer()"+" "+Thread.currentThread().getName());
		Iterable<Order> order=orderRepository.findByIssuedBy(custId);
		order.forEach(s->System.out.println(s + " "+ Thread.currentThread().getName()));
		System.out.println(order);
		System.out.println("After Fetching Customer Orders");
		Optional<Customer> customer=customerRepository.findById(custId);
		customer.ifPresent(s->System.out.println(s +" "+Thread.currentThread().getName()) );
		System.out.println("After Fetching Customer Details");
		return order;
	}
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		Customer savedCustomer= customerRepository.save(customer);
		return savedCustomer;
	}
	
	
	@PostMapping("/order")
	public Order savePerson(@RequestBody Order order)
	{
		Order savedOrder= orderRepository.save(order);
		return savedOrder;
	}
	
	  // To get all order for customer name
		@GetMapping("/customer/CustName")
		public Iterable<Customer> getAllOrdersforCustomerName(@RequestParam("customerName") String name,
                @RequestParam("customerAddress") String address,@QuerydslPredicate(root = Customer.class) Predicate predicate)
		{
		  //QCustomer qCustomer=new QCustomer("customer");
		    //Predicate predicate =qCustomer.customerAddress.startsWith("Noi");
		    Iterable<Customer> filteredCustomer= (Iterable<Customer>)customerRepository.findAll(predicate);
		    filteredCustomer.forEach(s->System.out.println(s));
				return filteredCustomer;
		}
		@GetMapping("/helo")
		public String getStatus()
		{
			System.out.println("In client 1");
			return "Hello";
		}
		
}
