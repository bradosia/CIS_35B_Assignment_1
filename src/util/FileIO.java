package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import model.Automobile;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class FileIO {
	public void read(String fileName) {
		Map<String, Integer> aMap = new HashMap<String, Integer>();

		List<Integer> list = new ArrayList<Integer>();
		File file = new File(fileName);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			String attributeName;
			String attributeValue;
			String attributeValueItem;

			while ((text = reader.readLine()) != null) {
				if (text.indexOf(':') != -1) {
					// attribute name found
					Scanner scan = new Scanner(text);
					scan.useDelimiter(":");
					if (scan.hasNextLine()) {
						attributeName = scan.next();
						attributeName = attributeName.trim();
						System.out.println("Attribute Name: " + attributeName);
					}
					if (scan.hasNextLine()) {
						text = scan.next();
					}
				}
				// handle attribute values
				Scanner scan = new Scanner(text);
				scan.useDelimiter(",");
				while (scan.hasNextLine()) {
					int optionPrice = 0;
					attributeValueItem = scan.next();
					Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(attributeValueItem);
					if (m.find()) {
						optionPrice = Integer.parseInt(m.group(1));
					}
					int openParanthesisPos = attributeValueItem.indexOf('(');
					if (openParanthesisPos != -1) {
						attributeValueItem = attributeValueItem.substring(0, openParanthesisPos);
					}
					attributeValueItem = attributeValueItem.trim();
					if (attributeValueItem.length() > 1) {
						System.out.println("Attribute Option: " + attributeValueItem + " Price: " + optionPrice);
					}
				}

				// list.add(Integer.parseInt(text));
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

	public void serializeAuto(Automobile autoObj) {

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
