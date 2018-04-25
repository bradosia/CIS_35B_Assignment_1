package driver;

import model.Automobile;

public class Driver {

	public static void main(String[] args) {
		util.FileIO autoutil = new util.FileIO();
		Automobile FordZTW = new Automobile();
		// Build Automobile Object from a file.
		autoutil.read("FordZTW.txt", FordZTW);
		// Print attributes before serialization
		FordZTW.print();
		// Serialize the object
		autoutil.serialize("FordZTW.data", FordZTW);
		// create deserialize automobile object
		Automobile FordZTW2 = new Automobile();
		// Deserialize the object and read it into memory.
		autoutil.deserialize("FordZTW.data", FordZTW2);
		// Print new attributes
		FordZTW2.print();
	}

}
