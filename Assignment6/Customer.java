/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Customer class
 * Due: 12/4/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Fru Nchang.
*/
public class Customer {
	private String name;
	private int age;
	
	/**
	 * creates a Customer object using the values 
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * copy constructor
	 * @param customer
	 */
	public Customer(Customer customer)
	{
		this(customer.name, customer.age);
	}
	
	
	//getters
	
	/**
	 * gets the customer's name
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * gets the customer's age
	 * @return
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * modifies the name field
	 * @param name
	 */
	
	// setters
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * modifies the age field
	 * @param age
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	
	/**
	 * @return String representation of the customer includes the name and age of the customer.
	 */
	public String toString()
	{
		return name +"," + age;
	}
}
