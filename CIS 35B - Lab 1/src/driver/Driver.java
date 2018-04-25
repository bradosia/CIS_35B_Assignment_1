//============================================================================
// Name        : Assignment 1
// Author      : Branden Lee
// Date        : 4/24/2018
// Description : Driver class for the KBB website application
//============================================================================

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
		// Deserialize the object and read it into memory.
		Automobile FordZTW2 = autoutil.deserialize("FordZTW.data");
		// Print new attributes
		if (FordZTW2 != null) {
			FordZTW2.print();
		} else {
			System.out.println("Object could not be deserialized");
		}
	}

}
