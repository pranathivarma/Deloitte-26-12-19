package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserPass {
	private static String fileName="D://user.txt";
	
	public static void main(String[] args) {
		FileWriter fw= null;
		try {
			fw = new FileWriter(fileName);
		}catch(IOException e) {
			e.printStackTrace();
		}
		PrintWriter out= null;
		out = new PrintWriter(fw);
		out.println("admin:admin123");
		out.println("user1:user1123");
		out.println("user2:user2123");
		out.println("user3:user3123");
		out.flush();
		
		if(fw != null) {
			try {
				fw.close();
			}catch(IOException e) {	
			    e.printStackTrace();
		    }
		}
		File file= new File(fileName);
		boolean fileExists = file.exists();
		System.out.println("file available?"+fileExists);
		if (fileExists) {
			System.out.println(file.getPath());
			FileReader reader= null;
			BufferedReader buffer = null;
			
			//read file contents
			try {
			     reader= new FileReader(file);
			} catch (FileNotFoundException e) {
				System.out.println("file does not exist");
				e.printStackTrace();
			}
			buffer = new BufferedReader(reader);
			String line = "";
			try {
				line = buffer.readLine();
				while(line != null) {
					System.out.println(line);
					line = buffer.readLine();
				} 
			}catch (IOException e) {
				System.out.println("error rading the file "+e.getMessage());
			}
			finally {
				if(buffer != null) {
					try {
						buffer.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
			}if(reader != null) {
				try {
					buffer.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
				}
			}
		}	
	}
}




