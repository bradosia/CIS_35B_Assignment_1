//============================================================================
// Name        : Assignment 1
// Author      : Branden Lee
// Date        : 4/24/2018
// Description : FileIO class for the KBB website application
//============================================================================

package util;

import java.io.*;

import model.Automobile;

public class FileIO {
	/*
	 * File pattern: newline (\n) separates different optionSet colon ":" separates
	 * optionSetName and optionSetOptions optionSetOptions may span multiple lines
	 * as long as no new optionSetName is found comma "," separates different
	 * optionSetOptions slash "/" separates different option values
	 */
	public void read(String fileName, Automobile autoObj) {
		String optionSetOptions;
		String lineNext;
		String[] optionParts;
		BufferedReader reader = null;
		int optionSetObjectIndex = -1;

		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			while ((lineNext = reader.readLine()) != null) {
				// optionSet
				if (lineNext.indexOf(':') != -1) {
					String[] optionSetParts = lineNext.split(":");
					optionSetOptions = optionSetParts[1];
					optionSetObjectIndex = autoObj.setOptionSet(optionSetParts[0].trim());
				} else {
					/*
					 * whole line is options if the optionSetName not found This allows options to
					 * be split on multiple lines for file readability.
					 */
					optionSetOptions = lineNext;
				}
				// optionSet options
				if (optionSetOptions.indexOf(',') != -1 && optionSetObjectIndex != -1) {
					optionParts = optionSetOptions.split(",");
				} else {
					optionParts = new String[] { optionSetOptions };
				}
				for (String optionPart : optionParts) {
					// part not blank
					if (optionPart.trim().length() > 0) {
						if (optionPart.indexOf('/') != -1) {
							String[] optionValueParts = optionPart.split("/");
							autoObj.setOptionSetOption(optionSetObjectIndex, optionValueParts[0].trim(),
									Double.parseDouble(optionValueParts[1].trim()));
						} else {
							autoObj.setOptionSetOption(optionSetObjectIndex, optionPart.trim(), 0);
						}
					}
				}
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
	}

	public void serialize(String fileName, Automobile autoObj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(autoObj);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + fileName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public Automobile deserialize(String fileName) {
		Automobile autoObj = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			autoObj = (Automobile) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserialized data read from " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return autoObj;
	}

	/*
	 * print() and toString()
	 */
	public void print() {
		System.out.print(toString());
	}

	public String toString() {
		return "FileIO Utility";
	}
}
