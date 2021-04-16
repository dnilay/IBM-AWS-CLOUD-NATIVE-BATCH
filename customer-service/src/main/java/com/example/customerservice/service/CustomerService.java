package com.example.customerservice.service;

import com.example.customerservice.shared.CustomerRequestModel;
import com.example.customerservice.shared.CustomerResponseModel;

public interface CustomerService {

    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails);
}
