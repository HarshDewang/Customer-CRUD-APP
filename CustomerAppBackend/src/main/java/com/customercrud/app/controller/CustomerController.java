package com.customercrud.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.customercrud.app.dto.CustomerDto;
import com.customercrud.app.entity.Customer;
import com.customercrud.app.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	 //API to Create Customer
	 @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDTO) {
	        try {
	            Customer createdCustomer = customerService.createCustomer(customerDTO);
	            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	        } catch (RuntimeException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
	        }
	    }
    //API to Update Customer Data
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDTO) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(customerId, customerDTO);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
    
    //API to Get All Customer
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving customers", e);
        }
    }
    
    //API to Get Customer By Id
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        try {
            Customer customer = customerService.getCustomerById(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    
    //API to Delete Customer By Id
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
	
	

}
