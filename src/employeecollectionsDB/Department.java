package employeecollectionsDB;

public enum Department {
	SALES(10), PURCHASE(20), ADMINISTRATION(30), RESEARCH(40);

	int code;

	Department(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static void getDepartmentNameByCode(final int code) {

		for (Department d : Department.values()) {
			if (d.getCode() == code) {
				System.out.println(d);
			}
		}
		System.out.println("No Department exists");
	}
}
