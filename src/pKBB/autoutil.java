package pKBB;
import java.io.*;

public class autoutil {
	static public class FileIO {
		public static void serializeAuto(cAutomobile autoObj) {

			try {
				FileOutputStream fileOut = new FileOutputStream("test.dat");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(autoObj);
				out.close();
				fileOut.close();
				System.out.printf("Serialized data is saved in test.dat");
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}
}
