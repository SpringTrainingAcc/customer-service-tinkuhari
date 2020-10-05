package com.customer.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from springboot 1.0";
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getCustomers(){
		List<Customer> list = customerDAO.getAllCustomers();
		return list;
	}
	
	@RequestMapping(value="/customers/{cusId}",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("cusId") String cusId) {
		return customerDAO.getCustomer(cusId);
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.POST,produces= {MediaType.APPLICATION_JSON_VALUE})
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}
	
	@RequestMapping(value="/customers/{cusId}",method=RequestMethod.DELETE,produces= {MediaType.APPLICATION_JSON_VALUE})
	public String deleteCustomer(@PathVariable("cusId") String cusId) {
		
//		if(customerDAO.getCustomer(cusId) == null) {
//			return "No such customer exists";
//		}
		return customerDAO.deleteCustomer(cusId);	
	}
	
	@RequestMapping(value="/customers/{cusId}",method=RequestMethod.PUT,produces= {MediaType.APPLICATION_JSON_VALUE})
	public String updateCustomer(@RequestBody Customer customer,@PathVariable("cusId") String cusId) {
		return customerDAO.updateCustomer(cusId,customer);
		
	}
	
	@RequestMapping(value="/mongoCustomers",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerM> getAllCustomers(){
		return customerService.findAll();
	}
	
	@RequestMapping(value="/mongoCustomer/{cusId}",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
	public CustomerM getMongoCustomer(@PathVariable("cusId") String cusId){
		return customerService.findById(cusId);
	}
	
	@RequestMapping(value="/mongoCustomer",method=RequestMethod.POST,produces= {MediaType.APPLICATION_JSON_VALUE})
	public CustomerM addMongoCustomer(@RequestBody CustomerM customerm){
		return customerService.addCustomer(customerm);
	}
	
	
}