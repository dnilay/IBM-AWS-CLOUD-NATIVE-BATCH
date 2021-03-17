package org.example;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
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
        int choice=0;
        do{
            System.out.println("1.Create");
            System.out.println("2.Display");
            System.out.println("0.Exit");
            System.out.print("Enter Your Choice: ");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("NAME: ");
                    String name = scanner.next();
                    customerService.createCustomer(new Customer(id,name));
                    System.out.print("customer created.");
                    break;
                case 2:
                    List<Customer> list=customerService.getAllCustomer();
                    Iterator<Customer> iterator=list.listIterator();
                    while(iterator.hasNext())
                    {
                        System.out.println(iterator.next());
                    }

            }

        }while(choice!=0);


    }

}
