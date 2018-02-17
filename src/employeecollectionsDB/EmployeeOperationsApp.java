package employeecollectionsDB;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeOperationsApp {
	EmployeeServiceImpl employeeoperationsimpl;

	EmployeeOperationsApp() {
		employeeoperationsimpl = new EmployeeServiceImpl();
	}

	public void updateEmp(final EmployeeServiceImpl employeearrayoperationsimpl, Scanner sc)
			throws EmployeeNotFoundException {
		System.out.println("Please enter existing employee Id to be updated: ");

		try {

			int existemployeeid = sc.nextInt();
			Employee e5 = employeearrayoperationsimpl.getEmployeeById(existemployeeid);
			int updoption = 0;
			do {
				System.out.println(
						"Please enter your option to update existing employee \n 1. Update an employeeID \n 2. Update employee number"
								+ " \n 3. Update an employee name \n 4. Update an employee salary"
								+ "\n 5. Update Employees age \n 6. Exit");

				updoption = sc.nextInt();

				switch (updoption) {
				case 1:
					System.out.println("Please enter new employee id to be updated: ");

					int updateid = sc.nextInt();

					Employee e6 = new Employee(e5.getNumber(), e5.getName(), e5.getSalary(), e5.getAge(), updateid);

					employeearrayoperationsimpl.updateEmployee(e6);

					break;
				case 2:
					System.out.println("Please enter employee number to be updated: ");
					int empNumber = sc.nextInt();
					employeearrayoperationsimpl.updateEmployee(
							new Employee(empNumber, e5.getName(), e5.getSalary(), e5.getAge(), existemployeeid));
					break;
				case 3:
					System.out.println("Please enter employee name to be updated: ");
					String empName = sc.next();
					Employee e10 = new Employee(e5.getNumber(), empName, e5.getSalary(), e5.getAge(), existemployeeid);
					employeearrayoperationsimpl.updateEmployee(e10);

					break;
				case 4:
					System.out.println("Please enter employee salary to be updated: ");
					double updSalary = sc.nextDouble();
					Employee e12 = new Employee(e5.getNumber(), e5.getName(), updSalary, e5.getAge(), existemployeeid);

					employeearrayoperationsimpl.updateEmployee(e12);
					break;
				case 5:
					System.out.println("Please enter employee age to be updated: ");
					int updAge = sc.nextInt();

					// Employee e5 = employeearrayoperationsimpl.getEmployeeById(existemployeeid);
					Employee e14 = new Employee(e5.getNumber(), e5.getName(), e5.getSalary(), updAge, existemployeeid);

					employeearrayoperationsimpl.updateEmployee(e14);

					break;
				case 6:
					break;
				}
				if (updoption == 6)
					break;

			} while (updoption != 6);

		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("exception raised");
		}
	}

	public static void main(String[] args) {
		EmployeeOperationsApp eop = new EmployeeOperationsApp();
		eop.employeeoperationsimpl.loadData();

		do {
			try {

				System.out.println(
						"Please enter your option to perform required option \n 1. Add an employee \n 2. Delete an employee"
								+ " \n 3. Update an employee \n 4. Display an employee "
								+ "\n 5. Display All Employees \n 6. Display Employee HRA \n 7. Display Employee Gross salary \n 8. Sort \n 9. Exit");

				Scanner scan = new Scanner(System.in);
				int option = scan.nextInt();
				switch (option) {
				case 1:
					System.out.println("Please enter employee number: ");
					int number = scan.nextInt();
					System.out.println("Please enter employee name: ");
					String name = scan.next();
					System.out.println("Please enter employee salary: ");
					double salary = scan.nextDouble();
					System.out.println("Please enter employee age: ");
					int age = scan.nextInt();
					System.out.println("Please enter employee Id: ");
					int employeeid = scan.nextInt();
					Employee e1 = new Employee(number, name, salary, age, employeeid);
					eop.employeeoperationsimpl.addEmployee(e1);
					break;
				case 2:
					System.out.println("Please enter employee ID to be deleted: ");
					int empid = scan.nextInt();
					Employee e = eop.employeeoperationsimpl.getEmployeeById(empid);
					eop.employeeoperationsimpl.deleteEmployee(e);
					break;
				case 3:
					eop.updateEmp(eop.employeeoperationsimpl, scan);
					break;
				case 4:
					System.out.println("Please enter employee ID to be displayed: ");
					int disempid = scan.nextInt();
					Employee e15;
					e15 = eop.employeeoperationsimpl.getEmployeeById(disempid);
					eop.employeeoperationsimpl.displayEmployee(e15);
					break;
				case 5:
					eop.employeeoperationsimpl.displayAllEmployee();
					// System.out.println(sb);
					break;
				case 6:
					System.out.println("Please enter employee ID whose HRA has to be cal: ");
					int hraempid = scan.nextInt();
					Employee e16;
					e16 = eop.employeeoperationsimpl.getEmployeeById(hraempid);
					eop.employeeoperationsimpl.displayEmployeeHra(e16);
					break;
				case 7:
					System.out.println("Please enter employee ID to be displayed: ");
					int grossempid = scan.nextInt();
					Employee e17;
					e17 = eop.employeeoperationsimpl.getEmployeeById(grossempid);
					eop.employeeoperationsimpl.displayEmployeeGrossSalary(e17);
					break;
				case 8:
					eop.sortByOption(eop.employeeoperationsimpl, scan);
					break;
				case 9:
					System.out.println("Bye...Byee");
					System.exit(0);
				default:
					break;
				}
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());

			} catch (Exception e) {
				e.printStackTrace();

			}

		} while (true);

	}
	private void checkMethod() {
		
	}

	private void sortByOption(final EmployeeServiceImpl employeearrayoperationsimpl, Scanner sc) {
		try {

			int updoption = 0;
			do {
				System.out.println("Please enter your option to sort \n 1. Sort by salary \n 2. Sort by salary and name"
						+ " \n 3. Sort by department \n 4. Sort by id" + "\n 5. Exit");

				updoption = sc.nextInt();

				switch (updoption) {
				case 1:
					employeearrayoperationsimpl.sortBySalary();
					break;
				case 2:
					employeearrayoperationsimpl.sortBySalaryAndName();
					break;
				case 3:
					employeearrayoperationsimpl.sortByDepartment();
					break;
				case 4:
					employeearrayoperationsimpl.sortByID();
					break;
				case 5:
					break;
				}

			} while (updoption != 5);

		} catch (Exception e) {

		}
	}
}
