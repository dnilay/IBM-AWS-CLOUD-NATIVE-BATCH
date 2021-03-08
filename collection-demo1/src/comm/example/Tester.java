package comm.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class Tester {

    public static void main(String args[])
    {
       /* //dynamic method dispatching
        Collection collection=new HashSet();
        //automatically performing autoboxing
        collection.add(10);
        collection.add(10);
        collection.add(new Integer(10));
        collection.add(true);
        collection.add("Hello");
        collection.add("hello");

        //collection.add(new Employee(UUID.randomUUID().toString(),"John","Doe","john@email.com"));
        Employee employee=new Employee(UUID.randomUUID().toString(),"John","Doe","John@email.com");
        Employee employee1=new Employee();
        employee1.setEmployeeID(employee.getEmployeeID());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        collection.add(employee);
        collection.add(employee1);
        System.out.println(collection);*/
        //implementing generics


        Collection<Employee> collection=new HashSet<Employee>();
        collection.add(new Employee("1","John","Doe","john@email.com"));
        collection.add(new Employee("2","Marry","Public","marry@email.com"));
        collection.add(new Employee("3","Sachin","Tendulkar","sachin@email.com"));
        System.out.println(collection);
        // retrieving record one by one using iterator
        Iterator<Employee> iterator=collection.iterator();
        while(iterator.hasNext())
        {
            Employee employee=iterator.next();

            System.out.println(employee);
        }
        //using enhanced for loop
        for(Employee e:collection)
        {
            System.out.println(e);
        }

























    }
}
