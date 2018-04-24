package driver;

import java.lang.*;
import java.util.*;

import model.Automobile;
import util.FileIO;

import java.io.*;


public class Driver {

	public static void main(String[] args) {
		util.FileIO autoutil = new util.FileIO();
		Automobile FordZTW = new Automobile();
		autoutil.read("FordZTW.txt", FordZTW);
		FordZTW.print();
		autoutil.serialize("FordZTW.data", FordZTW);
	}

}
