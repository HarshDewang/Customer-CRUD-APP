package com.customercrud.app.service;

import java.util.List;

import com.customercrud.app.dto.CustomerDto;
import com.customercrud.app.entity.Customer;



public interface CustomerService {
	
	Customer createCustomer(CustomerDto customerDTO);

    Customer updateCustomer(Long customerId, CustomerDto customerDTO);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    void deleteCustomer(Long customerId);
	
	
	
	

}
