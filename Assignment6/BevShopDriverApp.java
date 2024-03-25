/*
 * Description: BevShopDriver class - Data manager class
 * @author Faith Fru Nchang.
 */

/**
 * 
 */

import java.util.Scanner;
import java.io.*;
public class BevShopDriverApp {

	/**
	 * @param args
	 */
	static String customerName;
	static int time;
	static Day day;
	static String date;
	
	static String bevName;
	static int age;
	static String sizeOfBeverage="";
	static Size size;
	
	static Scanner stdIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		BevShop bevShop = new BevShop();
		
		// determines whether or not the user wants to start a new order
		String startNewOrder = "yes";
		
		System.out.println("***************************** Welcome to Bradley Beverage Shop ****************************");
		
		while (startNewOrder.equalsIgnoreCase("yes"))
		{
			System.out.print("Do you want to start a new order (yes/no): ");
			startNewOrder = stdIn.nextLine();
			if (!startNewOrder.equalsIgnoreCase("yes"))
				break;
			
			System.out.println("#--------------------------------------------------------------#");
			System.out.println("************* Great!!! PLEASE START YOUR ORDER *****************");
			
			try
			{
				// prompts the user to enter the time
				System.out.print("Please enter the time: ");
				time = stdIn.nextInt();
				
				// checks if the time is within 8 and 23 (8A.M TO 11 P.M)
				if (time < bevShop.getMinTime() || time > bevShop.getMaxTime())
				{
					System.out.printf("Sorry!!! we only sell beverages from %d to %d", bevShop.getMinTime(), bevShop.getMaxTime());
					break;
				}
				
				// cancels the extra white space
				stdIn.nextLine();
				// prompts the user for the day
				System.out.print("Please enter the the order day: ");
				date = stdIn.nextLine();
				if (date.equalsIgnoreCase("monday"))
					day = Day.MONDAY;
				else if (date.equalsIgnoreCase("tuesday"))
					day = Day.TUESDAY;
				else if (date.equalsIgnoreCase("wednesday"))
					day = Day.WEDNESDAY;
				else if (date.equalsIgnoreCase("thursday"))
					day = Day.THURSDAY;
				else if (date.equalsIgnoreCase("friday"))
					day = Day.FRIDAY;
				else if (date.equalsIgnoreCase("saturday"))
					day = Day.SATURDAY;
				else if (date.equalsIgnoreCase("sunday"))
					day = Day.SUNDAY;
				else
					day = null;
				
				System.out.print("Would you please enter your name: ");
				customerName = stdIn.nextLine();
				System.out.print("Would you please enter your age: ");
				age = stdIn.nextInt();
				stdIn.nextLine();

				System.out.println("Your total order for now is 0.0");
				// calls the startNewOrder method that adds the new order to the list of orders
				bevShop.startNewOrder(time, day, customerName, age);
				// creates a customer object
				Customer cust = new Customer(customerName, age);
				int orderNo = bevShop.getCurrentOrder().getOrderNo();
				
				// calls the AlcoholOrder method to handle Alcohol order
				AlcoholOrder(bevShop, orderNo);
				
				// calls the CoffeeOrder method to handle the COFFEE order
				CoffeeOrder(bevShop, orderNo);
				
				// calls the SmoothieOrder method to handle the SMOOTHIE order
				SmoothieOrder(bevShop, orderNo);
				
				
				// Display Order and customer Info
				System.out.println("\n****Customer Information****");
				System.out.println("Customer name and age: " + cust.toString());
				System.out.println("\n****ORDER INFORMATION****");
				System.out.println(bevShop.getCurrentOrder().toString());
				System.out.println("The total number of items ordered: "+ bevShop.getCurrentOrder().getTotalItems());
				System.out.println("The total number of alcoholic drinks orderd is: "+ bevShop.getNumOfAlcoholDrink());
				System.out.println("The total number of COFFEE ordered is: " + bevShop.getCurrentOrder().findNumOfBeveType(Type.COFFEE));
				System.out.println("The total number of SMOOTHIE ordered is: " + bevShop.getCurrentOrder().findNumOfBeveType(Type.SMOOTHIE));
				System.out.println("The TOTAL PRICE of your current order is: " + bevShop.totalOrderPrice(orderNo));
				
				
			}
			catch (Exception e)
			{
				System.out.println("The value is inputted is not valid. Please enter valid inputs");
			}
			
		}
		
		// displays the information of all the orders
		System.out.println("\nInformation of all orders");
		System.out.println(bevShop.toString());
		System.out.println("\nThank you for ordering");
		System.out.println("HAVE A GREAT DAY");
		
		
		
	}
	
	
	/**
	 * Handles an alcohol order
	 * @param bevShop - a BevShop object
	 * @param orderNo - an order number
	 */
	public static void AlcoholOrder(BevShop bevShop, int orderNo)
	{
		boolean shouldAddAlcoholicDrink = true;
		
		System.out.println("\n******* ALCOHOL ORDER *******");
		System.out.println("The minimum age to order alcoholic drink is " + bevShop.getMinAgeForAlcohol());
		
		if (bevShop.isValidAge(age))
		{
			System.out.println("Your age is above 20 and you are eligible to order alcohol");
			System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic drinks");
			String addBeverage;
			while (shouldAddAlcoholicDrink && bevShop.getNumOfAlcoholDrink() < bevShop.getMaxOrderForAlcohol())
			{
				if (bevShop.getNumOfAlcoholDrink() == 0)
					System.out.print("Do you want to add an alcohol drink (yes/no): ");
				else if (bevShop.getNumOfAlcoholDrink() == 1)
					System.out.print("Do you want to add a second alcohol drink (yes/no): ");
				else if (bevShop.getNumOfAlcoholDrink() == 2)
					System.out.print("Do you want to add a third alcohol drink: (yes/no): ");
				//  reads the user input to the addBeverage variable
				addBeverage = stdIn.nextLine();
				if (addBeverage.equalsIgnoreCase("yes"))
					shouldAddAlcoholicDrink = true;
				else
				{
					shouldAddAlcoholicDrink = false;
					break;
				}
				// prompts the user to enter the name of the alcoholic drink
				System.out.print("Enter the name of the alcoholic drink: ");
				bevName = stdIn.nextLine();
				
				// prompts the user for the size of the alcoholic drink
				System.out.print("Enter the size of the alcoholic drink: (SMALL, MEDIUM, LARGE): ");
				sizeOfBeverage = stdIn.nextLine();
				// determines the size of the alcoholic drink based on the user's input
				if (sizeOfBeverage.equalsIgnoreCase("small"))
					size = Size.SMALL;
				else if (sizeOfBeverage.equalsIgnoreCase("Medium"))
					size = Size.MEDIUM;
				else if (sizeOfBeverage.equalsIgnoreCase("large"))
					size = Size.LARGE;
				else
					size = null;
				// adds the new alcohol drink order to the current order
				bevShop.processAlcoholOrder(bevName, size);
				
				System.out.print("The current number of alcoholic drinks in your order is " + bevShop.getNumOfAlcoholDrink());
				System.out.println("\nThe current Total Price on your is Order: " + bevShop.totalOrderPrice(orderNo));
				if (bevShop.getNumOfAlcoholDrink() < bevShop.getMaxOrderForAlcohol())
					System.out.println("Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
				else
					System.out.println("You have a maximum alcohol drinks for this order");
				
			}
			
		}
		else
		{
			System.out.println("Your Age is not appropriate for alcohol drink!!");
		}
		
	}
	
	
	/**
	 * Handles a COFFEE order
	 * @param bevShop - a BevShop object
	 * @param orderNO - an order number
	 */
	public static void CoffeeOrder(BevShop bevShop, int orderNO)
	{
		boolean  extraShot, extraSyrup;
		String shouldAddExtraCoffee, shouldAddExtraSyrup;
		String addCoffeeToOrder= "yes";
		
		System.out.println("\n******* COFFEE ORDER ********");
		try
		{
			// ensures the user wants to order a Coffee
			while (addCoffeeToOrder.equalsIgnoreCase("yes"))
			{
				System.out.print("Do you want to add a COFFEE to your order (yes/no): ");
				addCoffeeToOrder = stdIn.nextLine();
				if (!addCoffeeToOrder.equalsIgnoreCase("yes"))
					break;
				System.out.print("Enter the name of the coffee: ");
				bevName = stdIn.nextLine();
				System.out.print("Enter the size of the coffee (SMALL, MEDIUM,OR LARGE): ");
				sizeOfBeverage = stdIn.nextLine();
				// determines the size of the coffee based on the user's input
				if (sizeOfBeverage.equalsIgnoreCase("small"))
					size = Size.SMALL;
				else if (sizeOfBeverage.equalsIgnoreCase("Medium"))
					size = Size.MEDIUM;
				else if (sizeOfBeverage.equalsIgnoreCase("large"))
					size = Size.LARGE;
				else
					size = null;
				// prompts the user to whether or not extra coffee should be added
				System.out.println("Should the coffee contain extra shot of protein (yes/no): ");
				shouldAddExtraCoffee = stdIn.nextLine();
				// determines whether extra shot should be true or false
				if (shouldAddExtraCoffee.equalsIgnoreCase("yes"))
					extraShot = true;
				else 
					extraShot = false;
				
				// prompts the user to enter whether or not extra syrup should be added to the  coffee
				System.out.print("Shoould the coffee contain extra syrup (yes/no): ");
				shouldAddExtraSyrup = stdIn.nextLine();
				// determines if the extra shot should be true or false
				if (shouldAddExtraSyrup.equalsIgnoreCase("yes"))
					extraSyrup = true;
				else
					extraSyrup = false;
				// adds the Coffe to the current order
				bevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
				
				System.out.println("The current Total Price on your Order is: " + bevShop.totalOrderPrice(orderNO));
				
			}
			
		}
		catch (Exception e)
		{
			System.out.println("The value is inputted is not valid. Please enter valid inputs");
		}
	}
	
	
	/**
	 * Handles a SMOOTHIE order
	 * @param bevShop - a BevShop order
	 * @param orderNo - an order number
	 */
	public static void SmoothieOrder(BevShop bevShop, int orderNo)
	{
		int numOfFruits; 
		boolean shouldAddProtein;
		String addProtein;
		String addSmoothieToOrder = "yes";
		
		System.out.println("\n******* SMOOTHIE COFFEE *******");
		try
		{
			// ensures the user wants to order a Smoothie
			while (addSmoothieToOrder.equalsIgnoreCase("yes"))
			{
				// asks the user if they want to add a Smoothie to their order
				System.out.print("Do you want to add a SMOOTHIE to your order (yes/no): ");
				addSmoothieToOrder = stdIn.nextLine();
				if (!addSmoothieToOrder.equalsIgnoreCase("yes"))
					break;
				
				System.out.print("Enter the name of the coffee: ");
				bevName = stdIn.nextLine();
				System.out.print("Enter the number of fruits (between 1 and " + bevShop.getMaxNumOfFruits()+": ");
				numOfFruits = stdIn.nextInt();
				// ensures the number of fruits is between 1 and 5
				while (numOfFruits < 1 || numOfFruits > bevShop.getMaxNumOfFruits())
				{
					System.out.println("Please enter a number greater from to " + bevShop.getMaxNumOfFruits() + ": ");
					numOfFruits = stdIn.nextInt();
					
				}
				
				stdIn.nextLine();
				// prompts the user if they want to add Protein to their smoothie
				System.out.print("Do you want to add protein to your smoothie (yes/no): ");
				addProtein = stdIn.nextLine();
				if (addProtein.equalsIgnoreCase("yes"))
					shouldAddProtein = true;
				else 
					shouldAddProtein = false;
				
				// adds the smoothie to the current order
				bevShop.processSmoothieOrder(bevName, size, numOfFruits, shouldAddProtein);
				
				System.out.println("\nThe Total Price on the Order: " + bevShop.totalOrderPrice(orderNo));
			}
		
		}
		catch (Exception e)
		{
			System.out.println("The value is inputted is not valid. Please enter valid inputs");
		}
		
		
	}

}
