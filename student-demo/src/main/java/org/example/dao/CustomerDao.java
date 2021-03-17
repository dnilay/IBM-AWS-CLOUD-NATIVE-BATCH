package org.example.dao;

import org.example.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public void createCustomer(Customer customer);
    public List<Customer> getAllCustomer();

}
