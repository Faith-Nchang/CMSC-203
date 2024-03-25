/*
 * Description: Alcohol class - a type of Beverage
 * @author Faith Fru Nchang.
*/
public class Alcohol extends Beverage{
   private boolean isWeekend;
   private final double EXTRA_PRICE = 0.6;
   
   /**
    *  creates an Alchohol object from using the values
    * @param bevName
    * @param size
    * @param isWeekend
    */
   public Alcohol(String bevName, Size size, boolean isWeekend)
   {
	   super(bevName, Type.ALCOHOL, size);
	   this.isWeekend = isWeekend;
   }
   
   /**
    * computes the price of the alcohol
    * @return alcoholPrice
    */
   public double calcPrice()
   {
	   double alcoholPrice = addSizePrice();
	   if (isWeekend)
		   alcoholPrice += EXTRA_PRICE;
	   return alcoholPrice;
   }
   
   
   /**
    * Checks if this Beverage equals to anotherBev
    * @param anotherBev
    * @return true if the name, type, size and base price and whether beverage is offered in weekend or not are the same, false otherwise
    */
   public boolean equals(Alcohol anotherBev)
   {
	   boolean isEqual;
	   if ((super.equals(anotherBev)) && (this.isWeekend == anotherBev.isWeekend))
		   isEqual = true;
	   else
		   isEqual = false;
	   return isEqual;
   }
   
   /**
    * checks if it is the weekend
    * @return indicates whether or not it is the weekend
    */
   public boolean isWeekend()
   {
	   return this.isWeekend;
   }
   
   
   //setters
   /**
    * modifies the value of isWeekend
    * @param isWeekend - whether or not it is the weekend
    */
   public void setIsWeekend(boolean isWeekend)
   {
	   this.isWeekend = isWeekend;
   }
   
   
   // getters
   /**
    * gets isWeekend
    * @return whether or not it is the weekend
    */
   public boolean getIsWeekend()
   {
	   return isWeekend;
   }
   /**
    * represents an Alcohol object as a string
    */
   public String toString()
   {
	  return super.toString() + "," +  isWeekend + "," + calcPrice();
   }
}
