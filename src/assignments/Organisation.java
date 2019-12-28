package assignments;

public class Organisation {
	
	static Employee[] emps = new Employee[5];
	
	public static void main(String[] args) {
		
		
	
		Department HR= new Department("HR","Hyd");
		Department Dev=new Department("Dev","chennai");
		@SuppressWarnings("unused")
		Department Test=new Department("Test","Mumbai");
		
		Address a1=new Address(31, "B", "hyd", "Telangana");
		Address a2=new Address(49, "MG road", "Bangalore", "Karnataka");
		Address a3=new Address(60, "Wellington St.", "sec", "Telangana");
		Address a4=new Address(92, "c", "hyd", "Telangana");
		Address a5= new Address(34,"d","hyd","telangana");
		
		Employee e1= new Employee("Kishore", a1, 12, Dev);
		Employee e2= new Employee("sanjay",a2,34,Dev);
		Employee e3= new Employee("Vishnu",a3,56,Dev);
		Employee e4= new Employee("Prani",a4,78,HR);
		Employee e5= new Employee("Ram", a5, 52, null);
		
		emps[0]=e1;
		emps[1]=e2;
		emps[2]=e3;
		emps[3]=e4;
		emps[4]=e5;
		
		printEmployee("Dev");
		getDepartment(e4);
		getEmployees();
	
  }		
	
		public static void printEmployee(String dept) {
			
			for(int i=0;i<5;i++)
			{
				if(emps[i].getD()!= null && emps[i].getD().getName().equals(dept))
					System.out.println(emps[i]);
			
			}
			
		}
		public static void getDepartment(Employee emp) {
					System.out.println(emp.getD().getName());
				
		}
		public static void getEmployees() {
			for(int i=0;i<5;i++) {
				if(emps[i].getD() == null)
					System.out.println(emps[i]);	
			}
		}
  
}