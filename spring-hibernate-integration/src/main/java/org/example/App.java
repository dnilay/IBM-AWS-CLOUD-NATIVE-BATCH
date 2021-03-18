package org.example;


import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class App
{
    
    private CustomerService customerService;

    

    public App() {
		customerService=new CustomerServiceImpl();
	}



	public static void main(String[] args )
    {

        App app=new App();
        Customer c=app.customerService.createCustomer(new Customer(101,"marry"));

        System.out.println(c);
    }
}
