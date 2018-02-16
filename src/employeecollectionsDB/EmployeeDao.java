package employeecollectionsDB;

import java.sql.SQLException;

public interface EmployeeDao {
	
	boolean addEmployee(Employee e) throws SQLException;
	
	boolean deleteEmployee(Employee e) throws SQLException;
	
	boolean updateEmployee(Employee e) throws SQLException;
	
	void selectEmployee(Employee e) throws SQLException;
	
	void selectAllEmployee() throws SQLException;

}
