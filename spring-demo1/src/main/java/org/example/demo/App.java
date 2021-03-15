package org.example.demo;

import org.example.demo.bean.BaseBallCoach;
import org.example.demo.bean.Coach;
import org.example.demo.bean.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context=
        		new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach=context.getBean("theCoach",BaseBallCoach.class);
        System.out.println(myCoach.getDailyWorkout());
    }
}
