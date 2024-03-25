import java.util.ArrayList;
import java.util.Random;
/*
 * Description: Order class - process orders the Beverage shop receives
 * @author Faith Fru Nchang.
*/
public class Order implements OrderInterface, Comparable<Order>{
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	/**
	 * creates an Order object using the parameters
	 * @param OrderTime - time of the order
	 * @param orderDay - day of the order
	 * @param cust - customer 
	 */
	public Order(int OrderTime, Day orderDay, Customer cust)
	{
		this.orderTime = OrderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(cust);
		this.orderNo = generateOrder();
	}

	
	// GETTERS

	/**
	 * gets the order number
	 * @return
	 */
	public int getOrderNo()
	{
		return orderNo;
	}
	
	/**
	 * gets the order day
	 * @return order day
	 */
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * gets the order time
	 * @return order time
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 *  gets the customer
	 * @return
	 */
	public Customer getCustomer()
	{
		return new Customer(customer);
	}
	
	/**
	 * gets the order day
	 * @return
	 */
	public Day getDay()
	{
		return orderDay;
	}
	
	
	// SETTERS
	
	/**
	 * modifies the value of the orderNo
	 * @param n
	 */
	public void setOrderNo(int orderNo)
	{
		this.orderNo = orderNo;
	}
	
	/**
	 *  modifies the value of the orderTime
	 * @param orderTime
	 */
	public void setOrderTime(int orderTime)
	{
		this.orderTime = orderTime;
	}
	
	/**
	 * modifies the value of customer
	 * @param cust - a Customer 
	 */
	public void setCustomer(Customer cust)
	{
		this.customer = new Customer(cust);
	}
	/**
	 * modifies the value of the orderDay
	 * @param day
	 */
	public void setOrderDay(Day day)
	{
		this.orderDay = day;
	}
	
	/**
	 * total number of items ordered within this order
	 * @return - total number of items
	 */
	public int getTotalItems()
	{
		return beverages.size();
	}
	
	
	
	
	/**
	 * generates random number between 10000 and 90000
	 * @return order number
	 */
	public int generateOrder()
	{
		final int MIN_NUM = 10000;
		final int MAX_NUM = 90000;
		// creates a random object
		Random rand = new Random();
		// generates a random # from 10000 to 90000
		orderNo = rand.nextInt((MAX_NUM + 1) - MIN_NUM) + MIN_NUM;
		return orderNo;
	}
	
	
	/**
	 * computes the number of beverages of the same type within an order
	 * @return numOfBeveType
	 */
	public int findNumOfBeveType(Type type)
	{
		// stores the number of beverage of a specific type within an order
		int numOfBeveType =0;
		// loops through the arrayList
		for (int i =0; i < beverages.size(); i++)
		{
			// checks if a current beverage is of the specific type
			if (beverages.get(i).getType() == type)
			{
				numOfBeveType++;
			}
		}
		return numOfBeveType;
	}
	
	/**
	 * returns the beverage listed in the itemNo of the order
	 * @param itemNo - an index of a beverage
	 * @return beverage at the specified itemNo
	 */
	public Beverage getBeverage(int itemNo)
	{
		return beverages.get(itemNo);
	}
	
	
	/**
	 * calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal()
	{
		double totalOrderPrice = 0.0;
		// loops through the beverages array list
		for (int itemNo =0; itemNo < beverages.size(); itemNo++)
		{
			// calculates the price of each beverage and adds it to the total price of the order
			totalOrderPrice += beverages.get(itemNo).calcPrice();
		}
		return totalOrderPrice;
	}
	
	
	
	/**
	 * checks if the order day is a Saturday or Sunday
	 * @return true if the day is a weekend day
	 */
	public boolean isWeekend()
	{
		// checks if the order day is a Saturday or Sunday
		if (this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * String representation of the order, Includes order number, time , day, customer name and age and the list of beverages
	 */
	public String toString()
	{
		String str =  orderNo +","+ orderTime +","+orderDay+"," + customer.getName() +"," +customer.getAge() +","+beverages;
		return str;
	}
	/**
	 * compares this order with another order
	 * @param anotherOrder - an  Order object
	 * @return 0 if the two Orders are the same, 1 if this Order is greater than the other, -1 otherwise
	 */
	public int compareTo(Order anotherOrder)
	{
		if (this.orderNo == anotherOrder.orderNo)
		{
			return 0;
		}
		else if (this.orderNo > anotherOrder.orderNo)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	
	/**
	 * adds an Alcohol beverage to the order
	 * @param bevName - beverage Name
	 * @param size - beverage size
	 */
	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol beverage = new Alcohol(bevName, size, isWeekend());
		beverages.add(beverage);
	}
	
	
	/**
	 * adds a Coffee beverage to the order
	 * @param bevName - beverage name
	 * @param size - beverage size of type SIZE
	 * @param extraShot - true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup - true if the coffee beverage has extra syrup , false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		Coffee beverage = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(beverage);
	}

	
	/**
	 * adds a Smoothie beverage to the order
	 * bevName - beverage name
	 * size - beverage size
	 * numOfFruits - number of fruits added
	 * addProtein - true if protein is added, false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		Smoothie beverage = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(beverage);
	}


	
	
	
}
