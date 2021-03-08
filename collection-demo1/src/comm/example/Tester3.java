package comm.example;

import java.util.*;
import java.util.stream.Collectors;

public class Tester3 {

    public static void main (String args[])
    {
        /*Map<Integer, Employee> map=new Hashtable<Integer,Employee>();
        Employee employee1=new Employee("10","aa","aa","aa");
        Employee employee2=new Employee("10","aa","aa","aa");
        map.put(1,employee1);
        map.put(2,employee2);
        System.out.println(map.get(1).hashCode());
        System.out.println(map.get(2).hashCode());
        System.out.println(map+"\n"+map.hashCode());*/

        Properties prop=new Properties();
        prop.setProperty("user.name","admin");
        prop.setProperty("password","1234");
        prop.setProperty("url","demo url");
        prop.setProperty("a","10");
        System.out.println(prop.getProperty("user.name"));
        Collection collection=prop.values();
        boolean val=prop.containsKey("User.name");
        System.out.println(val);
        Enumeration e=prop.keys();
        Iterator i=e.asIterator();
        while (i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println(collection);
    }
}
