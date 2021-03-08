package mypack.example;

import java.util.*;

public class Tester3 {

    private static Scanner scanner = new Scanner(System.in);
    private List<mypack.example.Employee> list1 = new ArrayList<mypack.example.Employee>();
    public static void main(String args[]) {

Tester3 test=new Tester3();


        int choose = 0;
        do {
            System.out.println(" 1: to insert");
            System.out.println(" 2: to remove");
            System.out.println(" 3: to display");
            System.out.println("enter your choice: ");
            choose= scanner.nextInt();

            switch (choose) {

                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter last name: ");
                    String lName = scanner.next();
                    System.out.print("Enter emil name: ");
                    String email = scanner.next();
                    test.list1.add(new mypack.example.Employee(UUID.randomUUID().toString(), firstName, lName, email));
                    System.out.println(test.list1);
                    break;
                case 2:
                    Iterator<mypack.example.Employee> iterator = test.list1.iterator();
                    System.out.println("delete the following");
                    int id = scanner.nextInt();
                    while (iterator.hasNext()) {

                        Employee e = iterator.next();
                        if (e.getEmployeeID().equals(id)) {
                            System.out.println(true);
                            //Employee e=iterator.next();
                            test.list1.remove(e);
                            //System.out.println(list1.size());
                        }

                    }
                    break;
                case 3:
                    System.out.println(test.list1);
                    break;


            }
        } while (choose!=0);

    }
}



