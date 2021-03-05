package com.test;

import com.demo.Attendance;
import static com.example.Day.*;
import static java.lang.System.out;
public class Tester {

    public static void main(String args[])
    {
        Attendance attendance=new Attendance(MONDAY,"John",true);
        out.println(attendance);
        Attendance attendance1=new Attendance(SUNDAY,"Marry",false);
        System.out.println(attendance1);
    }
}
