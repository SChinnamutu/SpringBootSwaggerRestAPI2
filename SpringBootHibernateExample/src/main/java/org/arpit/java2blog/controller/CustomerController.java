package org.arpit.java2blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.arpit.java2blog.model.Customer;
import org.arpit.java2blog.responseHandler.ResponseHandler;
import org.arpit.java2blog.service.CustomerService;
import org.arpit.java2blog.to.ResponseTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "CustomerController", description = "REST APIs related to Customer Entity!!!!")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "Get list of Customers in the System ", response = Iterable.class, tags = "getAllCustomers")
	@GetMapping(value = "/getAllCustomers", headers = "Accept=application/json")
	public List<Customer> getAllCustomers() {
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		return listOfCustomers;
	}

	@ApiOperation(value = "Get customer using Id in the System ", response = Iterable.class, tags = "GetCustomerUsingId")
	@GetMapping(value = "/getCustomer/{id}", headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}

	@ApiOperation(value = "Add Customer in the System ", response = Iterable.class, tags = "AddCustomer")
	@PostMapping(value = "/addCustomer", headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {	
		if(customer.getId()==0){
			customerService.addCustomer(customer);
		}else{	
			customerService.updateCustomer(customer);
		}
		return customer;
	}

	@ApiOperation(value = "Update Customer in the System ", response = Iterable.class, tags = "UpdateCustomer")
	@PutMapping(value = "/updateCustomer/{id}", headers = "Accept=application/json")
	public ResponseTo updateCustomer(@RequestBody Customer customer) {
		 customerService.updateCustomer(customer);
		 return ResponseHandler.createResponse("Customer updated successfully.");
	}

	@ApiOperation(value = "Delete Customer in the System ", response = Iterable.class, tags = "DeleteCustomer")
	@DeleteMapping(value = "/deleteCustomer/{id}", headers = "Accept=application/json")
	public ResponseTo deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return ResponseHandler.createResponse("Customer deleted successfully.");

	}	
}
