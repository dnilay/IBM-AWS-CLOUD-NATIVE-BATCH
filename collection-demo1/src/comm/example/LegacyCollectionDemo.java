package comm.example;

import java.util.Enumeration;
import java.util.Vector;

public class LegacyCollectionDemo {


    public static void main(String args[])
    {
        Vector<String> vector=new Vector<String>();
        vector.add("hello");
        vector.add("world");
        Enumeration<String> e=vector.elements();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }

        System.out.println(vector.indexOf("hello1"));
        System.out.println(vector.elementAt(0));
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
    }
}
