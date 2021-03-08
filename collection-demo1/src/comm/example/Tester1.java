package comm.example;

import java.util.*;

public class Tester1 {

    private static Scanner scanner=new Scanner(System.in);
    public static void main(String args[])
    {

        Collection<Integer> collection=new HashSet<Integer>();
        collection.add(10);
        collection.add(20);
        collection.add(10);
        List<Integer> list=new ArrayList<Integer>(collection);
        System.out.println(list);
     //list.add(new Employee());
       // list.add(new Employee());
        List<Employee> list1=new ArrayList<Employee>();
        list1.add(new Employee("1","a","b","c"));
        list1.add(new Employee("2","e","f","g"));
        String id=new String("1");
        Iterator<Employee> iterator=list1.iterator();
        System.out.println(list1.size());
        while (iterator.hasNext())
        {

            Employee e=iterator.next();
            if (e.getEmployeeID().equals(id))
            {
                System.out.println(true);
                //Employee e=iterator.next();
                list1.remove(e);
                System.out.println(list1.size());
            }
        }
        System.out.println(list1);

        System.out.print("Enter first name: ");
        String fName=scanner.next();
        System.out.print("Enter last name: ");
        String lName=scanner.next();
        System.out.print("Enter emil name: ");
        String email=scanner.next();
        list1.add(new Employee(UUID.randomUUID().toString(),fName,lName,email));
        System.out.println(list1);

    }
}
