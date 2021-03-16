package org.example;

import java.util.Scanner;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	StudentService service=context.getBean("studentService",StudentServiceImpl.class);
       try {
    	   System.out.print("ID: ");
    	   int id=scanner.nextInt();
    	   System.out.println("First Name: ");
    	   String fName=scanner.next();
    	   System.out.println("last Name: ");
    	   String lName=scanner.next();
    	   System.out.println("Email: ");
    	   String email=scanner.next();
    	   Student student=service.createStudent(new Student(id, fName, lName, email));
    	   System.out.println("Student Created Sucessfully..."+student);
		
		
	} catch (Exception e) {
		
	}
    }
}
