package driver;

import java.lang.*;
import java.util.*;

import model.Automobile;
import util.FileIO;

import java.io.*;


public class Driver {

	public static void main(String[] args) {
		util.FileIO autoutil = new util.FileIO();
		
		autoutil.read("FordZTW.txt");
		
		Automobile FordZTW = new Automobile();
		FordZTW.example();
		FordZTW.print();
		
		autoutil.serializeAuto(FordZTW);
	}

}
