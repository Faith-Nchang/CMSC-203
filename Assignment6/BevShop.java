/*
 * Description: BevShop class - Data manager class
 * @author Faith Fru Nchang.
   
*/
import java.util.ArrayList;
public class BevShop implements BevShopInterface{
	private int numOfAlcoholDrinks;
	private Order currentOrder;
	private ArrayList<Order> orderList = new ArrayList<>();

	private Customer customer;
	
	
	/**
	 * default constructor
	 */
	public BevShop()
	{
		numOfAlcoholDrinks =0;
	}
	
	
	/**
	 * creates a new order
	 * @param time - time of the order
	 * @param day - day of the order of type DAY
	 * @param customerName - customer name
	 * @param customerAge - customer age
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		customer = new Customer(customerName, customerAge);
		currentOrder = new Order(time, day, customer);
		orderList.add(currentOrder);
		numOfAlcoholDrinks =0;
	}
	
	/**
	 * finds an order based the order number
	 * @return the index of the order in the list of Orders if found or -1 if not found
	 */
	public int findOrder(int orderNo)
	{
		int index =0;
		// LOOPS THROUGH ALL THE ORDERS IN THE ORDER LIST
		for (int i =0; i < orderList.size(); i++)
		{
			if (orderList.get(i).getOrderNo() == orderNo)
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	/**
	 * returns the constant value for the maximum number of fruits
	 * @return Max_FRUIT
	 */
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	
	/**
	 *  constant maximum number of alcohol beverages/per order offered by the beverage shop
	 * @return MAX_ORDER_FOR_ALCOHOL
	 */
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	
	/**
	 * returns the constant value for the Maximum age for offering Alcohol drink
	 * @return MIN_AGE_FOR_ALCOHOL
	 */
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	
	
	/**
	 * returns constant maximum number of alcohol beverages/per order offered by the beverage shop
	 * @return numOfAlcoholDrinks
	 */
	public int getNumOfAlcoholDrink()
	{
		return numOfAlcoholDrinks;
	}
	
	
	/**
	 * returns Order in the list of orders at the index Notes: this method returns the shallow copy of the order
	 * @return Order at a specific index
	 */
	public Order getOrderAtIndex(int index)
	{
		return orderList.get(index);
	}
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	public boolean isEligibleForMore()
	{
		// checks if the current # of alcohol drinks is less than the max # of alcohol drinks
		if (numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	
	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 * @param numOfFruits 
	 * @return true if numOfFruits is greater than the Maximum fruits allowed, otherwise returns false
	 */
	public boolean isMaxFruit(int numOfFruits)
	{
		if (numOfFruits > MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	
	/**
	 * check if the age is valid for obtaining an alcohol drink
	 * @param age - the age
	 * @returns true if the age is greater than the minimum eligible age, false otherwise
	 */
	public boolean isValidAge(int age)
	{
		// CHECKS WHETHER THE CUSTOMER IS ELIGIBLE TO PURCHASE ALCOHOL
		if (age >= MIN_AGE_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	
	/**
	 * checks if the time is between 8 and 23
	 * @param time - represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean isValidTime(int time)
	{
		// checks if the time is between 8 and 23
		if (time >=8 && time <= 23)
			return true;
		else 
			return false;
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName - beverage name
	 * @param size - beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size)
	{
		// checks if the number of alcoholic drinks is less than 3
		if (isEligibleForMore())
		{
			currentOrder.addNewBeverage(bevName, size);
			numOfAlcoholDrinks++;
		}
	}
	
	
	/**
	 * adds a Coffee object to the current Order
	 * @param bevName - beverage name
	 * @param size - beverage size
	 * @param extraShot - true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup - true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}
	
	
	/**
	 * adds a Smoothie  to the current Order
	 * @param bevName - beverage name
	 * @param size - size of beverage
	 * @param numOfFruits - number of fruits added
	 * @param addProtein - whether or not protein was added
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		if (numOfFruits < MAX_FRUIT)
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	
	/**
	 * sorts the orders within this bevShop
	 */
	public void sortOrders()
	{
		int arrLength = orderList.size(); 
		int minIndex;
		Order temp;
		  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < arrLength - 1; i++) { 
            // Find the minimum element in unsorted array 
             minIndex = i; 
            for (int j = i + 1; j < arrLength; j++) { 
                if (orderList.get(j).compareTo(orderList.get(minIndex)) == -1) 
                    minIndex = j;
            } 
  
            // Swap the found minimum element with the first 
            // element 
            temp = orderList.get(minIndex); 
            orderList.set(minIndex, orderList.get(i));
            orderList.set(i, temp);
		} 
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale()
	{
		double totalSale = 0.0;
		// loops through the orderList array
		for (int i =0; i< orderList.size(); i++)
		{
			// adds the price of each Order to the totalSale
			totalSale += orderList.get(i).calcOrderTotal();
		}
		
		return totalSale;
	}
	
	
	/**
	 * returns total numbers of orders within the month
	 * @return total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
	
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo - order number
	 * @return the total price of an order
	 */
	public double totalOrderPrice(int orderNo)
	{
		//  gets the index of the order in the orderList
		int orderIndex = findOrder(orderNo);
		//  gets the Order from the OrderList
		Order order = orderList.get(orderIndex);
		// computes the total price of the order
		double price = order.calcOrderTotal();
		
		return price;
	}
	
	
	public String toString()
	{
		return orderList + "," + totalMonthlySale();
	}


	 // getters
	/**
	 * returns the current Order
	 * @return current order
	 */
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	
	/**
	 * returns the customer
	 * @return customer
	 */
	private Customer getCustomer()
	{
		return new Customer(customer);
	}
	
	
	/**
	 * gets the number of alcoholic drinks
	 * @return
	 */
	public int getNumOfAlcoholDrinks()
	{
		return this.numOfAlcoholDrinks;
	}
	
	
	// setters
	
	/**
	 * modifies the value of numOfAlcoholDrinks
	 * @param number - number of alcoholic drinks
	 */
	public void setNumOfAlcoholDrinks(int number)
	{
		this.numOfAlcoholDrinks = number;
	}
	
	
	
	/**
	 * changes the current order
	 * @param otherOrder - Order object
	 */
	public void setCurrentOrder(Order otherOrder)
	{
		this.currentOrder = otherOrder;
	}
	
	
	/**
	 * gets the MIN_TIME
	 * @return MIN_TIME
	 */
	public int getMinTime()
	{
		return MIN_TIME;
	}
	
	/**
	 * gets the MAX_TIME
	 * @return MAX_TIME
	 */
	public int getMaxTime()
	{
		return MAX_TIME;
	}

	
	/**
	 * returns the list of orders
	 * @return
	 */
	public ArrayList<Order> getOrderList() {
		return this.orderList;
	}
	
}


