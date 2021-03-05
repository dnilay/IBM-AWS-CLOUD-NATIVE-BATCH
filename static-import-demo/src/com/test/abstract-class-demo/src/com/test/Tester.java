package com.test;

import com.example.MyService;
import com.example.MyServiceImpl;

public class Tester {

    public static void main(String args[])
    {
        MyService myService=new MyServiceImpl();
        myService.a();
        System.out.println(MyService.MAX);
    }
}
