package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import com.pluralsight.NorthwindTradersSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //MVC

    // Model

    // View

    // Controller

    @RequestMapping(path="/customers", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(path="/customers", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customer;
    }

    @RequestMapping(path="/customers/{id}", method=RequestMethod.PUT)
    public String updateCustomer(@PathVariable int id) {
        return "This is the id: " + id;
    }


}
