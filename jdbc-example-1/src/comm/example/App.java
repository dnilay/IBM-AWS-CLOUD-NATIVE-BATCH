package comm.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import comm.example.exception.EmployeeNotFoundException;
import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		/*
		 * try { //step-1 Register The Driver DriverManager.deregisterDriver(new
		 * com.mysql.cj.jdbc.Driver()); //Step-2 Create Connection Connection
		 * connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr",
		 * "root", "root"); //Step-3 Create A statement object Statement
		 * statement=connection.createStatement(); //step-4 execute the query ResultSet
		 * resultSet=statement.executeQuery("select * from employees");
		 * System.out.println("ID\tFIRST NAME\tLASTNAME\tEMAIL\tSALARY\tBONUS");
		 * while(resultSet.next()) {
		 * System.out.println(resultSet.getInt("id")+"\t"+resultSet.getString(
		 * "first_name") +"\t"+resultSet.getString("last_name")+
		 * "\t"+resultSet.getInt("salary") +"\t"+resultSet.getInt("bonus")); }
		 * 
		 * 
		 * 
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */
		EmployeeService service = new EmployeeServiceImpl();
		int choice = 0;
		do {
			System.out.println("1.Create An Employee.");
			System.out.println("2.Display All Employees.");
			System.out.println("3. Remove a record.");
			System.out.println("0.Exit.");
			System.out.print("Enter Your Choice. ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("ID: ");
				int id = scanner.nextInt();
				System.out.println("First Name: ");
				String fName = scanner.next();
				System.out.println("Last Name: ");
				String lName = scanner.next();
				System.out.println("Email: ");
				String email = scanner.next();
				System.out.println("Salary: ");
				int salary = scanner.nextInt();
				System.out.println("Bonus: ");
				int bonus = scanner.nextInt();
				Employee e1=service.createEmployee(new Employee(id, fName, lName, email, salary, bonus));
				System.out.println("employee sucessfully created: "+e1);
				break;

			case 2:
				EmployeeService employeeService = new EmployeeServiceImpl();
				try {
					List<Employee> employees = employeeService.getAllEmployees();
					if(employees.isEmpty())
					{
						System.err.println("\nempty table.");
					}
					for (Employee e : employees) {
						System.out.println(e);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.print("ID: ");
				id = scanner.nextInt();
				try {
					employeeService = new EmployeeServiceImpl();
					employeeService.removeEmployeeById(id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (EmployeeNotFoundException e) {
					System.err.println(e.getMessaage());
				}
				break;
				
				
			case 0:
				System.out.println("Bye....!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
				break;
			}

		} while (choice != 0);

	}

}
