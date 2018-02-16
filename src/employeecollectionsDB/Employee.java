package employeecollectionsDB;

import java.util.Comparator;

public class Employee {

	private int number;
	private String name;
	private double salary;
	private static String company_name;
	private int age;
	private int employeeid;

	{
		salary = 10000;
	}

	static {
		company_name = "XYZ Comp";
	}

	Employee(Employee e) {
		this.number = e.number;
		this.name = e.name;
		this.salary = e.salary;
	}

	Employee() {

	}

	Employee(int number, String name, double salary) {
		this.number = number;
		this.name = name;
		this.salary = salary;
	}

	Employee(int number, String name, double salary, int age, int employeeid) {
		this.number = number;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.employeeid = employeeid;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getCompany_name() {
		return company_name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setEmployee(final int number, final String name, final double salary) {
		this.number = number;
		this.name = name;
		this.salary = salary;
	}

	public void displayEmployee() {
		System.out.println("Number: " + number + " Name: " + name + " Salary: " + salary);
	}

	public double calculateHra() {
		return 0.2 * salary;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", salary=" + salary + ", age=" + age + ", employeeid="
				+ employeeid + "]";
	}

}
