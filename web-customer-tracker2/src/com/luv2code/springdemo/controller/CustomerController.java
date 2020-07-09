package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model themodel) {
		
		//get customers from Dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		themodel.addAttribute("customers",theCustomers);
		return "list-customer";
	}
	
	@GetMapping("/showFormAdd")
	public String ShowFormForAdd(Model TheModel) {
		
		Customer theCustomer = new Customer();
		TheModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model theModel) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set the customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		//send over to our form 
		
		
		return "customer-form";
	}

}