package sort;

import java.util.Arrays;
import java.util.Comparator;

import compare.Employee;

public class Sorter {

	public static void main(String[] args) {
		
		Arrays.sort(args);
		for(String s:args) {
			System.out.println(s);
		}
		
		Employee e1=new Employee("ankit",123,5000);
		Employee e2=new Employee("Rahul",345,6500);
		
		Employee emps[]= new Employee[2];
		emps[0]=e1;
		emps[1]=e2;
		
		Arrays.sort(emps,new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return  e2.getName().compareToIgnoreCase(e1.getName());
			
			
			}});
		for(Employee e : emps)
			System.out.println(e);
		
		Arrays.sort(emps,new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return  e1.getId() - e2.getId();
			
		}});
		
		for(Employee e : emps)
			System.out.println(e);
	
	Arrays.sort(emps,new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return  (int) (e1.getSalary() - e2.getSalary());
		
	}});
	
	for(Employee e : emps)
		System.out.println(e);
}
}


