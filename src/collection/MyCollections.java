package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MyCollections {

	public static void main(String[] args) {
		Vector<String> v= new Vector<>();
		
		v.add("Ankit");
		v.add("amit");
		v.add("laptop");
		v.add("hi");
		
		int len=v.size();
		System.out.println(len);
		
		for(String s : v) {
			System.out.println(s);
		}
		
		Enumeration<String> E= v.elements();
		while(E.hasMoreElements()) {
			System.out.println(E.nextElement());
		}
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(85);
		list.add(45);
		list.add(93);
		list.add(51);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		{
		int sum=0;
		
		for(int i=0;i<4;i++)
		{
			sum = sum + list.get(i);
		}
		System.out.println(sum);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("asha", 123));
		students.add(new Student("nina", 456));
		students.add(new Student("amir", 588));
		students.add(new Student("venu", 173));
		students.add(new Student("amit", 273));
		students.add(new Student("Adil", 183));
		
		Iterator<Student> sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
			}
		
		//sort students list
		Collections.sort(students, new Comparator<Student>() {
            @Override
			public int compare(Student s1, Student s2) {
				
				return s1.getName().compareTo(s2.getName());
			}
			
		});
		sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
			}
		
		//sort students rollno.
		Collections.sort(students, new Comparator<Student>() {
            @Override
			public int compare(Student s1, Student s2) {
				
				return s1.getRoll() - s2.getRoll();
			}
		});
			
		sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getRoll());
			}
		Collections.sort(students, new StudentNameSorter());
		System.out.println(getRollNumber(students,"asha"));
					
	}
	
	public static int getRollNumber(List<Student> list, String studentName) {
		Iterator<Student> sdIt = list.iterator();
		while(sdIt.hasNext()) {
			Student s= sdIt.next();
			if(s.getName().equals(studentName)) 
				return s.getRoll();
			
		}return 0;
	}

		
	
	
	public static void NameStartingWithA(List<Student> students) {
		Iterator<Student> sdIt = students.iterator();
		while(sdIt.hasNext()) {
			Student s = sdIt.next();
			if(s.getName().startsWith("a"))
			System.out.println(s);
			}
		
	}
	
	
	
	
	public static void sortByName(List<Student> students) {
		
	}
			
}

	


