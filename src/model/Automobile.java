package model;

public class Automobile implements java.io.Serializable {
	private transient long serialVersionUID;

	public void example() {

	}

	public void print() {

	}

	class Automotive { // This class will represent the Model.
		String modelName; // technically the make and model
		double basePrice;
		OptionSet opset[];

		void Model(int size, String n) {
			opset = new OptionSet[size];
			name = n;
		}

		class OptionSet {
			Option opt[];
			String name;

			OptionSet(String n, int size) {
				opt = new Option[size];
				name = n;
			}
		}
	}

	class Option {
		String name;
		float price;
	}
}