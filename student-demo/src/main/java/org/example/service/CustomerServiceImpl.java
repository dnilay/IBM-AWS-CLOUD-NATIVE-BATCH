package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.entity.Customer;

public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;
    {
        customerDao=new CustomerDaoImpl();
    }
    @Override
    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
    }
}
