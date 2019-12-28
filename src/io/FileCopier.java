package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintStream;

public class FileCopier {

	public static void main(String[] args) throws IOException {
		
		if(args.length <2) {
			System.out.println("Usage: java FileCopier infile outfile");
		}
		
		String  inFile = args[0];
		String outFile = args[1];
		
		//InputStream in;
		FileInputStream fis = null;
		try {
			fis= new FileInputStream(inFile);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		FileOutputStream fout= null;
		PrintStream out= null;
		try {
			fout = new  FileOutputStream(outFile);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		out = new PrintStream(fout);
		try {
			int bite = fis.read();
			while(bite != -1) {
				out.println(bite);
				bite=fis.read();
			}
			out.flush();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			   if(out != null) {
					out.close();
			}if(fis != null) {
				try {
					fis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
	     }
	}
}
		



