package lesson2_3.capsule.practice2;

public class Main {
	public static void main(String[] args) {
		//Employeeクラスのインスタンスを作成
		Employee employee = new Employee("John Doe", 1001, 50000.0);

		// Employeeの情報を表示
		System.out.println("Employee Name: " + employee.getName());
		System.out.println("Employee ID: " + employee.getEmployeeID());
		System.out.println("Employee Salary: $" + employee.salary);

		// 給与を増額
		employee.raiseSalary(5000.0);
		System.out.println("New Employee Salary: $" + employee.salary);

		// Managerクラスのインスタンスを作成
		Manager manager = new Manager("Alice Smith", 2001, 75000.0, "Human Resources");

		// Managerの情報を表示
		System.out.println("Manager Name: " + manager.getName());
		System.out.println("Manager ID: " + manager.getEmployeeID());
		System.out.println("Manager Salary: $" + manager.salary);
		System.out.println("Manager Department: " + manager.getDepartment());

		// Managerの給与を増額
		manager.raiseSalary(10000.0);
		System.out.println("New Manager Salary: $" + manager.salary);
	}
}
