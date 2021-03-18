package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.entity.Customer;


public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;

    
    public CustomerServiceImpl() {
		customerDao=new CustomerDaoImpl();
	}


	@Override
    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }
}
