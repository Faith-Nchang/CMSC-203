/*
 * Description: Coffee class - a type of Beverage
 * @author Faith Fru Nchang.
*/


public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_PRICE = 0.5;
	
	/**
	 *  creates a Coffee object using the given values
	 * @param bevName - beverage name
	 * @param size - beverage size
	 * @param extraShot - contains extra coffee
	 * @param extraSyrup - contains extra syrup
	 */
	public Coffee (String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		// calls the Beverage's constructor
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * calculates the price based on the base price, size, extra coffee shot, and extra syrup
	 * @return coffeePrice
	 */
	public double calcPrice()
	{
		// sets the coffeePrice as the base price
		double coffeePrice = addSizePrice();
		
		// checks if the coffee contains extra shot of coffee
		if (extraShot == true)
			coffeePrice += EXTRA_SHOT_PRICE;
		// checks if the coffee contains extra syrup
		if (extraSyrup == true)
			coffeePrice += EXTRA_SHOT_PRICE;
		
		return coffeePrice;
	}
	
	/**
	 * checks if this Beverage equals another beverage
	 * @param coffee
	 * @return
	 */
	public boolean equals(Coffee coffee)
	{
		boolean isEqual;
		/*
		 * checks if the all the attributes (extraShot, extraSyrup, name, size, and type) are the same
		 */
		if ((this.extraShot == coffee.extraShot) && (this.extraSyrup == coffee.extraSyrup) && super.equals(coffee))
			isEqual = true;
		else
			isEqual = false;
		return isEqual;
	}
	
	// getters
	
	/**
	 * indicates whether or not an exra shot was added
	 * @return extraShot
	 */
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	/**
	 * indicates whether or not extra syrup is added
	 * @return extraSyrup
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	
	// setters
	/**
	 * modifies the value of extraShot
	 * @param extraShot
	 */
	public void setExtraShot(boolean extraShot)
	{
		this.extraShot = extraShot;
	}
	
	
	/**
	 * modifies the value of extraSyrup
	 * @param extraSyrup
	 */
	public void setExtraSyrup(boolean extraSyrup)
	{
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * represents a Coffee Beverage in the following format: name, size, extra shot, extra syrup, and the price
	 */
	public String toString()
	{
		String str = super.toString() + "," + this.extraShot + "," + this.extraSyrup + "," + this.calcPrice();
		return str;
	}
}
