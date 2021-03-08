package comm.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class Tester {

    public static void main(String args[])
    {
        //dynamic method dispatching
        Collection collection=new HashSet();
        //automatically performing autoboxing
        collection.add(10);
        collection.add(10);
        collection.add(new Integer(10));
        collection.add(true);
        collection.add("Hello");
        collection.add("hello");
        collection.add(new Employee(UUID.randomUUID().toString(),"John","Doe","john@email.com"));
        System.out.println(collection);
    }
}
