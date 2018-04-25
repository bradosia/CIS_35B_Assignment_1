package model;

public class Automobile implements java.io.Serializable {
	private static final long serialVersionUID = 1362422403381823640L;
	private String modelName;
	private double basePrice; // double is not an exact decimal.
	private OptionSet optionSetList[];
	private int optionSetListListLength;

	/*
	 * Constructor
	 */
	public Automobile() {
		int size = 10;
		modelName = "";
		basePrice = 0;
		optionSetList = new OptionSet[size];
		optionSetListListLength = 0;
		for (int i = 0; i < size; i++)
			optionSetList[i] = new OptionSet();
	}

	public Automobile(int size) {
		modelName = "";
		basePrice = 0;
		optionSetList = new OptionSet[size];
		optionSetListListLength = 0;
		for (int i = 0; i < size; i++)
			optionSetList[i] = new OptionSet();
	}

	/*
	 * Getter
	 */
	// Get Name of Automotive
	public String getName() {
		return modelName;
	}

	// Get Automotive Base Price
	public double getPrice() {
		return basePrice;
	}

	// Get OptionSet (by index value)
	public OptionSet getOptionSet(int index) {
		OptionSet optionSetObject = null;
		try {
			optionSetObject = optionSetList[index];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return optionSetObject;
	}

	public int length() {
		return optionSetListListLength;
	}

	/*
	 * Find
	 */
	// Find OptionSet with name
	public OptionSet findOptionSet(String name) {
		OptionSet optionSetObject = null;
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i].getName() == name) {
				optionSetObject = optionSetList[i];
			}
		}
		return optionSetObject;
	}

	/*
	 * Setter
	 */
	// SetName
	public void setName(String name) {
		modelName = name;
	}

	// Set Base Price
	public void setPrice(double price_) {
		basePrice = price_;
	}

	public int setOptionSet(String name) {
		OptionSet optionSetObject = getOptionSet(optionSetListListLength);
		optionSetObject.setName(name);
		return optionSetListListLength++;
	}

	// Set values of OptionSet
	public int setOptionSetOption(int indexSet, String name, double price_) {
		int indexReturn = -1;
		OptionSet optionSetObject = getOptionSet(indexSet);
		indexReturn = optionSetObject.setOption(name, price_);
		return indexReturn;
	}

	public void print() {
		StringBuffer stringBufferObject;
		OptionSet.Option optionObject;
		int i, j, n, n1;
		n = length();
		stringBufferObject = new StringBuffer("");
		stringBufferObject.append("Auto Model: ").append(getName()).append(" w/ Base Price: $").append(getPrice());
		for (i = 0; i < n; i++) {
			stringBufferObject = new StringBuffer("");
			stringBufferObject.append(optionSetList[i].getName()).append(": ");
			n1 = optionSetList[i].length();
			for (j = 0; j < n1; j++) {
				optionObject = optionSetList[i].getOption(j);
				stringBufferObject.append(optionObject.getName()).append(" for $").append(optionObject.getPrice());
				if (j < n1 - 1) {
					stringBufferObject.append(", ");
				}
			}
			System.out.println(stringBufferObject);
		}
	}

	protected class OptionSet implements java.io.Serializable {
		private static final long serialVersionUID = 5846223453457830887L;
		private Option optionList[];
		private String optionSetName;
		private int optionListLength;

		protected OptionSet() {
			int size = 10;
			optionList = new Option[size];
			optionSetName = "";
			optionListLength = 0;
			for (int i = 0; i < size; i++)
				optionList[i] = new Option();
		}

		protected OptionSet(String name, int size) {
			optionList = new Option[size];
			optionSetName = name;
			optionListLength = 0;
			for (int i = 0; i < size; i++)
				optionList[i] = new Option();
		}

		protected void setName(String name) {
			optionSetName = name;
		}

		// Find Option with name (in context of OptionSet)
		protected Option findOptionSet(String name) {
			Option optionObject = null;
			for (int i = 0; i < optionList.length; i++) {
				if (optionList[i].getName() == name) {
					optionObject = optionList[i];
				}
			}
			return optionObject;
		}

		/*
		 * Getter
		 */
		protected String getName() {
			return optionSetName;
		}

		// Get OptionSet (by index value)
		protected Option getOption(int index) {
			Option optionObject = null;
			try {
				optionObject = optionList[index];
			} catch (Exception e) {
				e.printStackTrace();
			}
			return optionObject;
		}

		protected int length() {
			return optionListLength;
		}

		// Set values of Option (in context of OptionSet)
		protected int setOption(String name, double price_) {
			Option optionObject = getOption(optionListLength);
			optionObject.setName(name);
			optionObject.setPrice(price_);
			return optionListLength++;
		}

		protected class Option implements java.io.Serializable {
			private static final long serialVersionUID = 2272307185575003314L;
			private String optionName;
			private double price;

			protected Option() {
				optionName = "";
				price = 0;
			}

			protected Option(String name, double price_) {
				optionName = name;
				price = price_;
			}

			/*
			 * Getter
			 */
			protected String getName() {
				return optionName;
			}

			protected double getPrice() {
				return price;
			}

			/*
			 * Setter
			 */
			protected void setName(String name) {
				optionName = name;
			}

			protected void setPrice(double price_) {
				price = price_;
			}
		}
	}
}
