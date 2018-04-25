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
		String optionSetName;
		String optionSetOptions;
		String optionSetOptionName;
		String lineNext;
		BufferedReader reader = null;
		int optionSetObjectIndex = -1;

		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			while ((lineNext = reader.readLine()) != null) {
				// optionSet
				if (lineNext.indexOf(':') != -1) {
					String[] optionSetParts = lineNext.split(":");
					optionSetName = optionSetParts[0].trim();
					optionSetOptions = optionSetParts[1];
					optionSetObjectIndex = autoObj.setOptionSet(optionSetName);
				} else {
					/*
					 * whole line is options if the optionSetName not found This allows options to
					 * be split on multiple lines for file readability.
					 */
					optionSetOptions = lineNext;
				}
				// optionSet options
				if (optionSetOptions.indexOf(',') != -1 && optionSetObjectIndex != -1) {
					for (String optionPart : optionSetOptions.split(",")) {
						if (optionPart.indexOf('/') != -1) {
							String[] optionValueParts = optionPart.split("/");
							optionSetOptionName = optionValueParts[0];
							autoObj.setOptionSetOption(optionSetObjectIndex, optionValueParts[0].trim(),
									Double.parseDouble(optionValueParts[1].trim()));
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

	public void deserialize(String fileName, Automobile autoObj) {
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
	}
}
