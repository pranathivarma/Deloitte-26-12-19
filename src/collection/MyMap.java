package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyMap {

	public static void  main(String[] args) {
		Map<Integer, String> map= new HashMap<>();
		
		map.put(1,"laptop");
		map.put(2,"mobile");
		map.put(3,"tablet");
		map.put(4,"desktop");
		
		String device = map.get(3);
		System.out.println(device);
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		System.out.println(getStudentName(123));
			
	}	
		
		public static String getStudentName(int rollNum) {
			Map<Integer, Student> map= getStudentMap();
			if(map.containsKey(rollNum)) {
				Student st = map.get(rollNum);
				return st.getName();
			}
			return null;
		}
		
		public static Map<Integer, Student> getStudentMap() {
			Map<Integer,Student> stds = new HashMap<>();
			List<Student> list = new ArrayList<>();
			Student akash = new Student("Akash",123);
			Student priya = new Student("Priya",456);
			Student abhi = new Student("Abhi",789);
			Student rajesh = new Student("Rajesh",357);
			list.add(priya);
			list.add(abhi);
			list.add(akash);
			list.add(rajesh);
			Iterator<Student> its = list.iterator();
			while(its.hasNext()) {
				Student st = its.next();
			    stds.put(st.getRoll(), st);			
		    }
		return stds;
		
		}
		
	}

	



