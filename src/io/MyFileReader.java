package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
	
	private static String fileName="D://data.txt";

	public static void main(String[] args) {
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


