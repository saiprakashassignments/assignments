package employeecollectionsDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeServiceImpl implements EmployeeService {

	public List<Employee> originalEmployee;
	public EmployeeDaoImpl edi;

	EmployeeServiceImpl() {
		originalEmployee = new LinkedList<Employee>();
		edi = new EmployeeDaoImpl();
	}

	public void loadData() {
		try {
			PreparedStatement statement = edi.connection.prepareStatement("select * from imcs.users ");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Employee e;

				e = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getInt(4), resultSet.getInt(5));

				originalEmployee.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addEmployee(Employee e) {
		if (e.getSalary() < 5000)
			throw new InvalidSalaryException("Salary is too low, please increase to minimum ");
		originalEmployee.add(e);
		try {
			edi.addEmployee(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deleteEmployee(Employee e) throws EmployeeNotFoundException {
		System.out.println("Delete Employee ");
		try {
			edi.deleteEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void updateEmployee(Employee e) throws EmployeeNotFoundException {
		if (e.getSalary() < 5000) {
			throw new InvalidSalaryException("Salary is too low, please increase to minimum of 5000");
		}
		System.out.println("Update Employee ");
		boolean flag = false;
		try {
			edi.updateEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void displayEmployee(Employee e) {
		System.out.println("Display Employee called: ");
		try {
			edi.selectEmployee(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void displayAllEmployee() {
		System.out.println("Display All Employee called: ");
		try {
			edi.selectAllEmployee();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void displayEmployeeHra(Employee e) {
		System.out.println("Display Employee HRA called: ");
		for (Employee eo : originalEmployee) {
			if (e.getEmployeeid() == eo.getEmployeeid()) {
				EmployeeUtil.calculateHra(eo);
			}
		}

	}

	public void displayEmployeeGrossSalary(Employee e) {
		System.out.println("Display Employee Gross Salary called: ");
		for (Employee eo : originalEmployee) {
			if (e.getEmployeeid() == eo.getEmployeeid()) {
				EmployeeUtil.calculateTotalSalary(eo);

			}
		}

	}

	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException {
		for (Employee eo : originalEmployee) {
			if (empId == eo.getEmployeeid()) {
				return eo;
			}
		}
		throw new EmployeeNotFoundException("No employee with given id or name found");
	}

	public void sortBySalary() {
		System.out.println("sort by salary called: ");
		try {
			edi.sortBySalary();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void sortBySalaryAndName() {
		System.out.println("sort by salary and name called: ");
		try {
			edi.sortBySalaryAndName();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void sortByDepartment() {
		System.out.println("sort by Department called: ");
		try {
			edi.sortByDepartment();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void sortByID() {
		System.out.println("sort by id called: ");
		try {
			edi.sortByID();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
