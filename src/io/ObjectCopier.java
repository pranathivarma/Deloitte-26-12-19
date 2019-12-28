package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import collection.Student;

public class ObjectCopier {
	
	public static void main(String[] args) {
		Student st = new Student("akash",12345);
		try {
		    FileOutputStream fout = new FileOutputStream("D://std.ser");
		    ObjectOutputStream oos = new ObjectOutputStream(fout);
		    oos.writeObject(st);
		    oos.flush();
		    oos.close();
		    System.out.println("object serialised");
		}
		catch(IOException ioe) {
			System.out.println("object failed to serialise..."+ioe.getMessage());
		}
	}

}
