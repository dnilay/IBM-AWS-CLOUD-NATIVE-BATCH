package org.example;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService;

    static {
        customerService = new CustomerServiceImpl();
    }

    public static void main(String[] args) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("NAME: ");
        String name = scanner.next();
        customerService.createCustomer(new Customer(id,name));
        System.out.print("customer created.");
    }

}
