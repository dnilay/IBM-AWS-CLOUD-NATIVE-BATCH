package comm.example;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

public class Tester2 {
    private static  int i=1;
    private Map<Integer,Employee> map=new HashMap<Integer,Employee>();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String args[])
    {

        Tester2 test=new Tester2();
        int choice=0;
        do{
            System.out.println("1. Insert Record.");
            System.out.println("2. Display Record");
            System.out.println("3. Remove a Record");
            System.out.println("4. Update a Record");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("First Name-> ");
                    String fName=scanner.next();
                    System.out.println("Last Name-> ");
                    String lName=scanner.next();
                    System.out.println("Email-> ");
                    String email=scanner.next();
                    test.insertRecord(fName,lName,email);
                    break;
                case 2:
                    Collection<Employee> employees=test.map.values();
                    Iterator<Employee> iterator=employees.iterator();
                    while(iterator.hasNext())
                    {
                        System.out.println(iterator.next().toString());
                    }
                    break;

                case 3:
                    System.out.print("Enter Key To remove: ");
                    int key=scanner.nextInt();
                    if(test.map.isEmpty())
                    {
                        System.out.println("no elements.");
                        break;
                    }
                    else
                    {
                        Employee employee=test.map.get(key);
                        if(employee!=null)
                        {
                            test.map.remove(key,employee);
                            System.out.println("item deleted with id: "+key);
                        }
                        else {
                            System.out.println("no such record found with the key "+key);
                        }

                    }
                    break;
                case 4:
                    System.out.print("enter key to update: ");
                    key=scanner.nextInt();
                    Employee employee=test.map.get(key);
                    System.out.println("First Name-> ");
                    fName=scanner.next();
                    System.out.println("Last Name-> ");
                    lName=scanner.next();
                    System.out.println("Email-> ");
                    email=scanner.next();
                    employee.setLastName(lName);
                    employee.setFirstName(fName);
                    employee.setEmail(email);
                    break;

                case 0:
                    System.out.println("Bye!>>>");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice:");
                    break;


            }


        }while(choice!=0);

    }

    private void insertRecord(String fName, String lName, String email) {
        map.put(i++,new Employee(UUID.randomUUID().toString(),fName,lName,email));
        System.out.println("Record Inserted Successfully");

    }
}
