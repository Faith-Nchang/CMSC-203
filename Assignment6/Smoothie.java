/*
 * Description: Smoothie class - type of Beverage
 *@author Faith Fru Nchang.
*/
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	private final double EXTRA_PROTEIN_COST = 1.50;
	private final double FRUIT_COST = 0.5;
	
	/**
	 * creates a Smoothie object using the values provided
	 * @param bevName - beverage name
	 * @param size - beverage size
	 * @param numOfFruits - number of fruits in the smoothie
	 * @param addProtein - indicates whether or not to add protein
	 */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}

	
	/**
	 * computes the price of a smoothie
	 * @return smoothiePrice
	 */
	public double calcPrice()
	{
		// sets the smoothie price to the base price + size price
		double smoothiePrice = addSizePrice();
		
		// computes the cost of all the fruits used and adds it to the smoothie price
		smoothiePrice += (this.numOfFruits * FRUIT_COST);
		// checks if the protein was added to the smoothie and adds the price to the smoothie price
		if (addProtein == true)
			smoothiePrice += EXTRA_PROTEIN_COST;
	
		
		return smoothiePrice;
	}
	
	/**
	 * checks if two objects are the same 
	 * @param otherObject
	 * @return true if the name, type, size and base price, number of Fruits and add protein are the same, false otherwise
	 */
	public boolean equals(Smoothie otherObject)
	{
		boolean isEqual;
		if ((super.equals(otherObject)) && (this.numOfFruits == otherObject.numOfFruits) && (this.addProtein == otherObject.addProtein) && (this.getBasePrice() == otherObject.getBasePrice()))
			 isEqual = true;
		else
			isEqual = false;
		return isEqual;
		
	}
	
	// getters
	/**
	 * indicates whether or not protein was added
	 * @return
	 */
	public boolean getAddProtein()
	{
		return addProtein;
	}
	/**
	 * gets the number of fruits
	 * @return
	 */
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	// setters
	
	/**
	 * modifies the value of addProtein
	 * @param addProtein
	 */
	public void setAddProtein(boolean addProtein)
	{
		this.addProtein = addProtein;
	}
	
	/**
	 * modifies the value of the numOfFruits
	 * @param numOfFruits
	 */
	public void setNumOfFruits(int numOfFruits)
	{
		this.numOfFruits = numOfFruits;
	}
	/**
	 * string representation of a smoothie
	 */
	public String toString()
	{
		return super.toString() +  "," + addProtein + "," + numOfFruits +"," + calcPrice();
	}
}
