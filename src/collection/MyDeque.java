package collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class MyDeque {
	public static void main(String[] args) {
		
		Hashtable<String,String> table=new Hashtable<>();
		table.put("admin","admin123");
		table.put("user","user123");
		
		Enumeration<String> enums = table.keys();
		while(enums.hasMoreElements()) {
			String key = enums.nextElement();
			String val = table.get(key);
			System.out.println(key+":"+val);
		}
		
	}
}
