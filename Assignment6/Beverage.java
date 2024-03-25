/*
 * Description: Beverage class
 * @author Faith Fru Nchang.
*/
public abstract class Beverage {
  private String bevName;
  private Type type;
  private Size size;
  private final double BASE_PRICE = 2.0; // base price of the items
  private final double SIZE_PRICE = 1.0; // price for adding an item size
  
  /**
   * creates a beverage object using the parameters
   * @param bevName
   * @param type
   * @param size
   */
  public Beverage(String bevName, Type type, Size size)
  {
	  this.bevName = bevName;
	  this.type = type;
	  this.size = size;
  }
  
  // getters
  /**
   * gets the beverage name
   * @return bevName
   */
  public String getBevName()
  {
	  return bevName;
  }
  
  /**
   * gets the beverage size
   * @return size
   */
  public Size getSize() {
	  return size;
  }
  
  /**
   * gets the beverage type
   * @return type
   */
  public Type getType()
  {
	  return type;
  }
  
  // setters
  /**
   *  changes the value of bevName
   * @param bevName - beverage name
   */
  public void setBevName(String bevName)
  {
	  this.bevName = bevName;
  }
  
 
 /**
  * changes the value of the type variable 
  * @param type - type of beverage
  */
  public void setType(Type type)
  {
	  this.type = type;
  }
  /**
   * changes the value of the size variable
   * @param size - size of the beverage
   */
  public void setSize(Size size)
  {
	  this.size = size;
  }
  
  /**
   * Gets the base price
   * @return base price
   */
  public double getBasePrice()
  {
	  return BASE_PRICE;
  }
  
  /**
   * checks if a beverage equals another beverage
   * @param otherBev - Beverage object
   * @return isEqual - if the two objects are equal
   */
  public boolean equals(Beverage otherBev)
  {
	  boolean isEqual;
	  if ((this.bevName).equals(otherBev.bevName) && (this.size == otherBev.size) && (this.type == otherBev.type))
	  {
		 isEqual = true; 
	  }
	  else
		  isEqual = false;
	  
	  return isEqual;
  }
  
  /**
   * Calculates the beverage price
   * @return beverage price
   */
  public abstract double calcPrice();
  
  /**
   * Calculates a new price by adding the size price to the base price. There is no additional cost for small size, for medium and large beverages the additional 
   * cost of size price is added to base price For example if the base price is 2 and SIZE_PRICE is .5 then the cost of small beverage is 2, the medium beverage is 2.5 and the large beverage is 3.
   * @return
   */
  public double addSizePrice()
  {
	  double price = 0.0;
	  /*
	   * determines the price of the beverage based on the base price and the size price
	   */
	  if (this.size == Size.SMALL)
		  price = BASE_PRICE;
	  else if (this.size == Size.MEDIUM)
		  price += (BASE_PRICE + SIZE_PRICE);
	  else if (this.size == Size.LARGE)
		  price += (BASE_PRICE + SIZE_PRICE + SIZE_PRICE);
	  return price;
  }
  /**
   * Represents a Beverage object in String with the format bevName, size
   */
  public String toString()
  {
	  return bevName + "," + size;
  }
}
