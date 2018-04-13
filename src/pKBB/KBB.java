package pKBB;

import java.lang.*;
import java.util.*;
import java.io.*;


public class KBB {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		File file = new File("file.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				list.add(Integer.parseInt(text));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		
		cAutomobile FordZTW = new cAutomobile();
		FordZTW.example();
		FordZTW.print();
		pKBB.autoutil.FileIO.serializeAuto(FordZTW);
		
		

		// print out the list
		System.out.println(list);
	}

}
