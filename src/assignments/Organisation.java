package assignments;

public class Organisation {
	public static void main(String[] args) {
	
		Department HR= new Department("Hyd");
		Department Dev=new Department("chennai");
		Department Test=new Department("Mumbai");
		
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
    }
}