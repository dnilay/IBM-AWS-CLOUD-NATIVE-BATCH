package com.example.customerservice.rest;

import com.example.customerservice.service.CustomerService;
import com.example.customerservice.shared.CustomerRequestModel;
import com.example.customerservice.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestModel));

    }


}
