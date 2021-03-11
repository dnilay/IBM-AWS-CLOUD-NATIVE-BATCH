package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file = new File(args[0]);

		try {
			// Create a buffered reader to read each line from standard in.
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(isr);
			// Create a print writer on this file.
			File f=new File("test.txt");
			PrintWriter out;
			String s;
			do {
				System.out.print("Enter file text. ");
				s=in.readLine();
				 out= new PrintWriter(f);
					out.println(s);
					
			}while(!s.equals("exit"));
			

			// Close the buffered reader and the file print writer.
			in.close();
			out.close();

		} catch (IOException e) {
			// Catch any IO exceptions.
			e.printStackTrace();
		}

	}

}
