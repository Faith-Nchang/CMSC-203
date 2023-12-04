/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: JUnit test BevShop class - Data manager class
 * Due: 12/4/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Fru Nchang.
   
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	BevShop bevShop;
	
	
	@BeforeEach
	void setUp() throws Exception {
		bevShop = new BevShop();
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		bevShop = null;
		
	}

	@Test
	void testStartNewOrder() {
		bevShop.startNewOrder(9, Day.TUESDAY, "Ishmael", 34);
		bevShop.startNewOrder(15, Day.WEDNESDAY, "Jesus", 55);
		
		assertEquals(2, bevShop.totalNumOfMonthlyOrders());
	}

	@Test
	void testFindOrder() {
		bevShop.startNewOrder(10, Day.FRIDAY, "Ishmael", 34);
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		
		int orderNo = bevShop.getOrderAtIndex(1).getOrderNo();
		
		assertEquals(1, bevShop.findOrder(orderNo));
	}

	@Test
	void testGetMaxNumOfFruits() {
		assertEquals(5, bevShop.getMaxNumOfFruits());
		
	}

	@Test
	void testGetMaxOrderForAlcohol() {
		assertEquals(3, bevShop.getMaxOrderForAlcohol());
	}

	@Test
	void testGetMinAgeForAlcohol() {
		assertEquals(21, bevShop.getMinAgeForAlcohol());
	}

	@Test
	void testGetNumOfAlcoholDrink() {
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		bevShop.processAlcoholOrder("Black legend", Size.SMALL);
		bevShop.processAlcoholOrder("wine", Size.LARGE);
		
		assertEquals(2, bevShop.getNumOfAlcoholDrinks());
	}

	@Test
	void testGetOrderAtIndex() {
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		bevShop.processCoffeeOrder("black", Size.SMALL, false, false);
		bevShop.processSmoothieOrder("Juice", Size.MEDIUM, 3, false);
		assertEquals(bevShop.getOrderAtIndex(0).getDay(), Day.SATURDAY );
	}
	@Test
	void testIsEligibleForMore() {
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		bevShop.processAlcoholOrder("Black legend", Size.SMALL);
		bevShop.processAlcoholOrder("wine", Size.LARGE);
		bevShop.processAlcoholOrder("bb", Size.SMALL);
		
		assertFalse(bevShop.isEligibleForMore());
		
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		assertTrue(bevShop.isEligibleForMore());
	}

	@Test
	void testIsMaxFruit() {
		assertTrue(bevShop.isMaxFruit(6));
		assertFalse(bevShop.isMaxFruit(3));
	}

	@Test
	void testIsValidAge() {
		assertTrue(bevShop.isValidAge(21));
		assertFalse(bevShop.isValidAge(20));
	}

	@Test
	void testIsValidTime() {
		assertFalse(bevShop.isValidTime(7));
		assertFalse(bevShop.isValidTime(24));
		assertTrue(bevShop.isValidTime(9));
	}

	@Test
	void testProcessAlcoholOrder() {
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		bevShop.processAlcoholOrder("Black legend", Size.SMALL);
		assertEquals("Black legend", bevShop.getCurrentOrder().getBeverage(0).getBevName());
	}

	@Test
	void testProcessCoffeeOrder() {
		bevShop.startNewOrder(16, Day.THURSDAY, "Jesus", 34);
		bevShop.processCoffeeOrder("Lattee", Size.SMALL, false, false);
		assertEquals(bevShop.getCurrentOrder().getBeverage(0).getSize(), Size.SMALL);
	}

	@Test
	void testProcessSmoothieOrder() {
		bevShop.startNewOrder(13, Day.MONDAY, "Jesus", 34);
		bevShop.processSmoothieOrder("Spinach", Size.LARGE, 2, true);
		assertEquals(bevShop.getCurrentOrder().getBeverage(0).getType(), Type.SMOOTHIE);
	}

	@Test
	void testSortOrders() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
		bevShop.processCoffeeOrder("winsa", Size.MEDIUM, false, false);

		bevShop.getCurrentOrder().setOrderNo(20000);
		
		bevShop.startNewOrder(14, Day.SUNDAY, "Lym", 25);
		bevShop.processCoffeeOrder("Cocka", Size.LARGE, false, false);
		bevShop.getCurrentOrder().setOrderNo(10000);
		
		bevShop.sortOrders();
		assertTrue((bevShop.getOrderAtIndex(0).getBeverage(0)).equals(bevShop.getCurrentOrder().getBeverage(0)));
		assertEquals(bevShop.getOrderAtIndex(1).getTotalItems(), 2);
	}

	@Test
	void testTotalMonthlySale() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
		bevShop.processCoffeeOrder("Cocka", Size.LARGE, false, false);
		
		bevShop.startNewOrder(13, Day.MONDAY, "Jesus", 34);
		bevShop.processCoffeeOrder("Cocka", Size.LARGE, false, false);

		
		bevShop.startNewOrder(15, Day.SATURDAY, "Lim", 55);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);


		assertEquals(14.6, bevShop.totalMonthlySale());
	}

	@Test
	void testTotalNumOfMonthlyOrders() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.startNewOrder(13, Day.MONDAY, "Jesus", 34);
		bevShop.startNewOrder(15, Day.SATURDAY, "and", 55);
		bevShop.startNewOrder(15, Day.SATURDAY, "ljd", 55);

		assertEquals(bevShop.totalNumOfMonthlyOrders(), 4);


	}

	@Test
	void testTotalOrderPrice() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
		bevShop.processCoffeeOrder("Cocka", Size.LARGE, false, false);
		assertEquals(7.0, bevShop.totalOrderPrice(0));
	}

	@Test
	void testToString() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
		
		bevShop.startNewOrder(15, Day.SATURDAY, "Jesus", 55);
		bevShop.processCoffeeOrder("black", Size.SMALL, false, false);
		bevShop.processSmoothieOrder("Juice", Size.MEDIUM, 3, false);
		
		String str = bevShop.getOrderList() +","+bevShop.totalMonthlySale();
		assertEquals(str, bevShop.toString());
	}

	@Test
	void testGetCurrentOrder() {
		Order order = new Order(10, Day.WEDNESDAY, new Customer("Faith", 33));
		bevShop.setCurrentOrder(order);
		assertEquals(bevShop.getCurrentOrder().compareTo(order), 0);
	}

	@Test
	void testGetNumOfAlcoholDrinks() {
		bevShop.startNewOrder(8, Day.WEDNESDAY, "Harry", 21);
		bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
		assertEquals(1, bevShop.getNumOfAlcoholDrinks());
	}

	@Test
	void testSetNumOfAlcoholDrinks() {
		bevShop.setNumOfAlcoholDrinks(2);
		assertEquals(bevShop.getNumOfAlcoholDrink(), 2);
	}

	@Test
	void testSetCurrentOrder() {
		Order order = new Order(21, Day.THURSDAY, new Customer("Faith", 33));
		bevShop.setCurrentOrder(order);
		assertEquals(bevShop.getCurrentOrder().compareTo(order), 0);
	}

	@Test
	void testGetMinTime() {
		assertEquals(8, bevShop.getMinTime());
	}

	@Test
	void testGetMaxTime() {
		assertEquals(23, bevShop.getMaxTime());
	}

}
