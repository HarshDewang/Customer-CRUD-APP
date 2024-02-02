package com.customercrud.app.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customercrud.app.dto.CustomerDto;
import com.customercrud.app.entity.Customer;
import com.customercrud.app.repository.CustomerRepository;
import com.customercrud.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(CustomerDto customerDTO) {
		Customer customer = new Customer();
		customer.setFirst_name(customerDTO.getFirst_name());
		customer.setLast_name(customerDTO.getLast_name());
		customer.setStreet(customerDTO.getStreet());
		customer.setAddress(customerDTO.getAddress());
		customer.setCity(customerDTO.getCity());
		customer.setState(customerDTO.getState());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhone(customerDTO.getPhone());

		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Long customerId, CustomerDto customerDTO) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isPresent()) {
			Customer existingCustomer = optionalCustomer.get();

			// Update customer fields with new data
			existingCustomer.setFirst_name(customerDTO.getFirst_name());
			existingCustomer.setLast_name(customerDTO.getLast_name());
			existingCustomer.setStreet(customerDTO.getStreet());
			existingCustomer.setAddress(customerDTO.getAddress());
			existingCustomer.setCity(customerDTO.getCity());
			existingCustomer.setState(customerDTO.getState());
			existingCustomer.setEmail(customerDTO.getEmail());
			existingCustomer.setPhone(customerDTO.getPhone());

			// Save and return the updated customer
			return customerRepository.save(existingCustomer);
		} else {
			// Handle the case when the customer with the given ID is not found
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		} else {
			// Handle the case when the customer with the given ID is not found
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}

	}

	@Override
	public void deleteCustomer(Long customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		} else {
			// Handle the case when the customer with the given ID is not found
			throw new RuntimeException("Customer not found with ID: " + customerId);
		}
	}

}
	
	

	
