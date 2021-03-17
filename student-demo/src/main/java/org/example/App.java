package org.example;

import org.example.entity.Customer;
import org.example.exception.CustomerNotFoundException;
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
            System.out.println("3.Find Customer By ID");
            System.out.println("4.Find Customer By Name");
            System.out.println("5. Update Customer.");
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
                    break;
                case 3:
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    Customer customer=customerService.getCustomerById(id);
                    if(customer==null)
                    {
                        throw new CustomerNotFoundException("no such customer with id: "+id);
                    }
                    System.out.println("customer found: \n"+customer);

                    break;
                case 4:
                    System.out.print("NAME: ");
                    name = scanner.next();
                    List<Customer> customers= customerService.getCustomerByName(name);
                    if(customers.isEmpty())
                    {
                        throw new CustomerNotFoundException("customer not found");
                    }
                    for(Customer c: customers)
                    {
                        System.out.println(c);
                    }
                    break;
                case 5:
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    Customer customer1=customerService.updateCustomer(id);
                    System.out.println("updation done.\n"+customer1);
                    break;
                default:
                    System.out.println("invalid choice.");
                    break;
                case 0:
                    System.out.println("bye.!");
                    System.exit(0);

            }

        }while(choice!=0);


    }

}
