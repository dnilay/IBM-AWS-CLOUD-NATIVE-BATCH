package org.example.service;

import org.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void createCustomer(Customer customer);
    public List<Customer> getAllCustomer();
}
