package employeecollectionsDB;

public class EmployeeUtil {

	// Changed method name from highpaid to given
	public static Employee highPaid(Employee e1, Employee e2) {

		return e1.getSalary() > e2.getSalary() ? e1 : e2; // updated from e.salary

	}

	// Changed method name from updatelowpaid to given
	public static Employee updateLowPaid(Employee e) {
		double incrementedSalary = e.getSalary() + 0.1 * e.getSalary(); // added logic to incorporate salary to
																		// setSalary
		e.setSalary(incrementedSalary);
		return e;
	}

	public static Employee newEmployee(Employee e) {
		Employee e1 = new Employee();
		e1 = e;
		return e1;
	}

	public static Employee elderEmployee(Employee e1, Employee e2) {

		return e1.getAge() > e2.getAge() ? e1 : e2;
	}

	public static void updateSalary(Employee e) {
		double updatedsalary = 0;
		if (e.getSalary() < 10000 && e.getAge() > 35) {
			updatedsalary = e.getSalary() * 0.15 + e.getSalary();
		} else if (e.getSalary() < 15000 && e.getAge() > 45) {
			updatedsalary = e.getSalary() * 0.2 + e.getSalary();
		} else if (e.getSalary() < 20000 && e.getAge() > 55) {
			updatedsalary = e.getSalary() * 0.25 + e.getSalary();
		}

		e.setSalary(updatedsalary);
	}

	public static void calculateTotalSalary(Employee e) {
		double da = 0;
		double hra = 0;
		if (e.getSalary() < 10000) {
			da = e.getSalary() * 0.08;
			hra = 0.15 * e.getSalary();
			System.out.println("Total gross salary is: "+(da+hra+e.getSalary()));
		} else if (e.getSalary() < 20000) {
			da = .1 * e.getSalary();
			hra = .2 * e.getSalary();
			System.out.println("Total gross salary is: "+(da+hra+e.getSalary()));
		} else if (e.getSalary() < 30000 && e.getAge() >= 40) {

			da = .15 * e.getSalary();
			hra = .27 * e.getSalary();
			System.out.println("Total gross salary is: "+(da+hra+e.getSalary()));
		} else if (e.getSalary() < 30000 && e.getAge() < 40) {
			da = .13 * e.getSalary();
			hra = .25 * e.getSalary();
			System.out.println("Total gross salary is: "+(da+hra+e.getSalary()));
		} else {
			da = .17 * e.getSalary();
			hra = .30 * e.getSalary();
			System.out.println("Total gross salary is: "+(da+hra+e.getSalary()));
		}
	}
	
	
	
	public static void calculateHra(Employee e) {
		double hra = 0;
		if (e.getSalary() < 10000) {
			hra = 0.15 * e.getSalary();
			System.out.println("HRA is: "+hra);
		} else if (e.getSalary() < 20000) {
			hra = .2 * e.getSalary();
			System.out.println("HRA is: "+hra);
		} else if (e.getSalary() < 30000 && e.getAge() >= 40) {
			hra = .27 * e.getSalary();
			System.out.println("HRA is: "+hra);
		} else if (e.getSalary() < 30000 && e.getAge() < 40) {
			hra = .25 * e.getSalary();
			System.out.println("HRA is: "+hra);
		} else {
			hra = .30 * e.getSalary();
			System.out.println("HRA is: "+hra);
		}
	}
	
}
