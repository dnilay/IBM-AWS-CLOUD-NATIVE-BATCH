package comm.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class Tester2 {

    public static void main(String args[])
    {
        Comparator comparator=new SalaryComparator();
        Set<Employee> set=new TreeSet<Employee>(comparator);
        Employee employee1=new Employee(UUID.randomUUID().toString().trim(),"name1",20000);
        Employee employee2=new Employee(UUID.randomUUID().toString().trim(),"name2",10000);
        Employee employee3=new Employee(UUID.randomUUID().toString().trim(),"name3",12000);
        Employee employee4=new Employee(UUID.randomUUID().toString().trim(),"name4",8000);
        set.add(employee1);
        set.add(employee2);
        set.add(employee4);
        set.add(employee3);
        for(Employee e:set)
        {
            System.out.println(e);
        }
    }
}
