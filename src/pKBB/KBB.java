package pKBB;

import java.lang.*;
import java.util.*;
import java.io.*;


public class KBB {

	public static void main(String[] args) {
		AutoUtility autoutil = new AutoUtility();
		AutoUtility.FileIO fileio = autoutil.new FileIO();
		
		fileio.read("FordZTW.txt");
		
		cAutomobile FordZTW = new cAutomobile();
		FordZTW.example();
		FordZTW.print();
	}

}
