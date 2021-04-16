package com.example.customerservice.service;

import com.example.customerservice.model.CustomerModel;
import com.example.customerservice.shared.CustomerRequestModel;
import com.example.customerservice.shared.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails);

    public List<CustomerModel> getAllCustomers();

}
