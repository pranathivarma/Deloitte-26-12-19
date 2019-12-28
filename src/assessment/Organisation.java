package assessment;

import java.util.ArrayList;

public class Organisation {
	private static ArrayList<Employee> emps;


	public static void main(String[] args) {
		
		generateEmployees();
		listAllEmployees();
		listEmployeeGivenDept("Dep1");
		listEmployeesGivenRole("Test");
		incrementSalariesForEmployeesGivenRole("test", 10);
		listEmployeesWithIncrementedSalaries();
		listEmployeesGivenManager(emps.get(0));

	}

	private static void listAllEmployees() {
		
		System.out.println("List of all Employees...\n");
		for(Employee e:emps) {
			System.out.println(e);
		}
		
		System.out.println();
		
	}
	private static void listEmployeeGivenDept(String dept) {
			
			
			for(Employee e: emps) {
				if(e.getDept().getName().equals(dept)) {
					System.out.println("Employee belonging to "+dept+" is "+e);
				}
			}
			System.out.println();
		}
	private static void listEmployeesGivenRole(String role) {
		
		for(Employee e: emps) {
			if(e.getRole().getName().equals(role)) {
				System.out.println("Employee with role as "+role+" is "+e);
			}
		}
		System.out.println();
	}
	private static void listEmployeesGivenManager(Employee emp) {
		
		System.out.println();
		System.out.println("Employees under manager "+emp.getName()+" are.......");
		for(Employee e: emps) {
			if(e.getManager()==emp) {
				System.out.println(e);
			}
		}
	}
	private static void incrementSalariesForEmployeesGivenRole(String role, int percent) {
		
	
		for(Employee e: emps) {
			if(e.getRole().getName().equalsIgnoreCase("Manager")) {
				e.incrementSalary(role, emps,percent);
			}
		}System.out.println("Salaries Incremented for role: "+role);
	}
	private static void listEmployeesWithIncrementedSalaries() {
		
		System.out.println();
		System.out.println("Employees with incremented salaries are......");
		for(Employee e: emps) {
			if(e.isSalaryInc()==true) {
				System.out.println(e);
			}
		}
		
	}

	private static void generateEmployees() {
		
		
		Role[] role = generateRoles();
		Department[] dept  =generateDepartments();
		emps = new ArrayList<>();
		
		Employee e1 = new Employee("Emp1",1,5000,role[0],dept[0],null);
		Employee e2 = new Employee("Emp2",2,5000,role[0],dept[1],null);
		Employee e3 = new Employee("Emp3",3,5000,role[1],dept[2],e2);
		Employee e4 = new Employee("Emp4",4,5000,role[1],dept[3],e1);
		Employee e5 = new Employee("Emp5",5,5000,role[2],dept[0],e2);
		Employee e6 = new Employee("Emp6",6,5000,role[2],dept[1],e1);
		
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);
		emps.add(e5);
		emps.add(e6);
		
		System.out.println("Employees are.......");
		System.out.println("");
		
	}

	private static Department[] generateDepartments() {
		
		Department[] dept = new Department[4];
		dept[0] = new Department("Dep1","Hyderabad");
		dept[1] = new Department("Dep2","Bengaluru");
		dept[2] = new Department("Dep3","Chennai");
		dept[3] = new Department("Dep4","Mumbai");
		return dept;
	}

	private static Role[] generateRoles() {
		
		Role[] roles = new Role[3];
		roles[0] = new Role("Manager");
		roles[1] = new Role("Dev");
		roles[2] = new Role("Test");
		return roles;
	}

}
