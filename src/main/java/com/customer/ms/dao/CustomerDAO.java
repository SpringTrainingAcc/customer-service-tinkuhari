package com.customer.ms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {
	
	private static final Map<String,Customer> cusMap = new HashMap<String,Customer>();
	
	static {
		initCus();
	}
	
	private static void initCus() {
		Customer cus1 = new Customer("C01", "Smith", "NY");
		Customer cus2 = new Customer("C02", "Allen", "CT");
		Customer cus3 = new Customer("C03", "Jones", "NJ");
		
		cusMap.put(cus1.getCustId(), cus1);
		cusMap.put(cus2.getCustId(), cus2);
		cusMap.put(cus3.getCustId(), cus3);
		
	}

	public List<Customer> getAllCustomers() {

		List<Customer> list = new ArrayList<>();
		list.addAll(cusMap.values());
		return list;	
		
	}

	public Customer getCustomer(String custId) {

		return cusMap.get(custId);
	}

	public Customer addCustomer(Customer customer) {
	
		cusMap.put(customer.getCustId(), customer);
		return customer;
	}
	
	public String deleteCustomer(String custId) {
		
		if(!cusMap.containsKey(custId)) {
			return "No such customer exists";
		}
		cusMap.remove(custId);
		return "Customer successfully deleted";
	}
	
	public String updateCustomer(String custId,Customer customer) {
		
		if(!cusMap.containsKey(custId)) {
			return "No such customer exists";
		}
		cusMap.replace(custId, customer);
		return "Customer successfully updated";
		
		
	}

}
