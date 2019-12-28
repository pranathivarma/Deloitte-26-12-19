package io;

import java.io.File;
import java.util.Date;

public class FileOperations {

	public static void main(String[] args) {
		//folder create
		File file = new File("D://Mydata");
		boolean done = file.mkdir();
		
		System.out.println("Folder: " +file.getName());
		
		String[] files = file.list();
		for(String s : files) {
			File f = new File(file.getPath()+"/"+s);
			System.out.println(f.getName()+"\t"+new Date(f.lastModified())+"\t"+f.length());
			
		}	

	}

}
