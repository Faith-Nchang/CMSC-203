/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Order class - a type of Beverage
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

class OrderTestStudent {
	Order order1, order2, order3;

	@BeforeEach
	void setUp() throws Exception {
		order1 = new Order(19, Day.FRIDAY, new Customer("Faith", 25));
		order2 = new Order(10, Day.SATURDAY, new Customer("Courage", 30));
		order3 = new Order(20, Day.SUNDAY, new Customer("Judith", 47));
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		order1 = order2 = order3 = null;
	}

	@Test
	void testGetOrderNo() {
		order1.setOrderNo(50000);
		order2.setOrderNo(10000);
		order3.setOrderNo(67000);
		assertEquals(50000, order1.getOrderNo());
		assertEquals(10000, order2.getOrderNo());
		assertEquals(67000, order3.getOrderNo());
	}

	@Test
	void testGetOrderDay() {
		assertEquals(Day.FRIDAY, order1.getOrderDay());
		assertEquals(Day.SATURDAY, order2.getOrderDay());
		assertEquals(Day.SUNDAY, order3.getDay());
	}

	@Test
	void testGetOrderTime() {
		assertEquals(19, order1.getOrderTime());
		assertEquals(10, order2.getOrderTime());
		assertEquals(20, order3.getOrderTime());
	}

	@Test
	void testGetCustomer() {
		assertEquals(order1.getCustomer().getName(), "Faith");
		assertEquals(order2.getCustomer().getAge(), 30);
		assertEquals(order3.getCustomer().getName(), "Judith");
	}

	@Test
	void testGetDay() {
		assertEquals(Day.FRIDAY, order1.getOrderDay());
		assertEquals(Day.SATURDAY, order2.getOrderDay());
		assertEquals(Day.SUNDAY, order3.getDay());
	}

	@Test
	void testSetOrderNo() {
		order1.setOrderNo(50000);
		order2.setOrderNo(10000);
		assertEquals(order1.getOrderNo(), 50000);
		assertEquals(order2.getOrderNo(), 10000);
	}

	@Test
	void testSetOrderTime() {
		order3.setOrderTime(16);
		order2.setOrderTime(12);
		order1.setOrderTime(15);
		
		assertEquals(16, order3.getOrderTime());
		assertEquals(12, order2.getOrderTime());
		assertEquals(15, order1.getOrderTime());
	}

	@Test
	void testSetCustomer() {
		order1.setCustomer(new Customer("Michelle", 34));
		assertEquals(order1.getCustomer().getName(), "Michelle");
		assertEquals(order1.getCustomer().getAge(), 34);
	}

	@Test
	void testSetOrderDay() {
		order2.setOrderDay(Day.MONDAY);
		order3.setOrderDay(Day.WEDNESDAY);
		
		assertEquals(order2.getDay(), Day.MONDAY);
		assertEquals(order3.getDay(), Day.WEDNESDAY);
		
	}

	@Test
	void testGetTotalItems() {
		assertEquals(0, order1.getTotalItems());
		assertEquals(0, order2.getTotalItems());
		
		order1.addNewBeverage("Beer", Size.SMALL);
		order1.addNewBeverage("Latte", Size.LARGE, true, false);
		assertEquals(2, order1.getTotalItems());
		
		order3.addNewBeverage("Apple", Size.MEDIUM, 0, false);
		order2.addNewBeverage("Juice", Size.SMALL, false, false);
		
		assertEquals(1, order2.getTotalItems());
		assertEquals(1, order3.getTotalItems());
	}

	@Test
	void testGenerateOrder() {
		int orderNo1 = order1.generateOrder();
		int orderNo2 = order2.generateOrder();
		assertEquals(orderNo1, order1.getOrderNo());
		assertEquals(orderNo2, order2.getOrderNo());
	}

	@Test
	void testFindNumOfBeveType() {
		order1.addNewBeverage("Wine", Size.MEDIUM);
		order1.addNewBeverage("Whisky", Size.SMALL);
		assertEquals(2, order1.findNumOfBeveType(Type.ALCOHOL));
		
		order3.addNewBeverage("Black Coffee", Size.MEDIUM, false, false);
		assertEquals(1, order3.findNumOfBeveType(Type.COFFEE));
	}

	@Test
	void testGetBeverage() {
		order2.addNewBeverage("Sweetener", Size.MEDIUM, 4, false);
		order2.addNewBeverage("Wine", Size.MEDIUM);
		order2.addNewBeverage("Whisky", Size.SMALL);
		
		assertEquals(order2.getBeverage(0).getBevName(), "Sweetener");
		assertEquals(order2.getBeverage(2).getBevName(), "Whisky");
	}

	@Test
	void testCalcOrderTotal() {
		order2.addNewBeverage("Juice", Size.SMALL, true, true);
		order2.addNewBeverage("Sweetener", Size.MEDIUM, 4, false);
		order2.addNewBeverage("Wine", Size.MEDIUM);
		order2.addNewBeverage("Whisky", Size.SMALL);
		assertEquals(14.2, order2.calcOrderTotal(), 0.001);
	}

	@Test
	void testIsWeekend() {
		assertFalse(order1.isWeekend());
		assertTrue(order2.isWeekend());
		assertTrue(order3.isWeekend());
	}

	@Test
	void testToString() {
		String str = order1.getOrderNo() +","+order1.getOrderTime() +"," +order1.getOrderDay() +","+ order1.getCustomer().getName() + ","+ order1.getCustomer().getAge() +","+ order1.beverages;
		assertEquals(str, order1.toString());
	}

	@Test
	void testCompareTo() {
		order1.setOrderNo(10000);
		order2.setOrderNo(25000);
		order3.setOrderNo(60000);
		
		assertEquals(-1, order1.compareTo(order2));
		assertEquals(-1, order1.compareTo(order3));
		assertEquals(1, order3.compareTo(order1));
		order1.setOrderNo(25000);
		assertEquals(0, order1.compareTo(order2));
	}

	@Test
	void testAddNewBeverageStringSize() {
		order1.addNewBeverage("Ran out of Ideas", Size.LARGE);
		assertEquals(1, order1.getTotalItems());
	}

	@Test
	void testAddNewBeverageStringSizeBooleanBoolean() {
		order2.addNewBeverage("OHIO", Size.SMALL, false, false);
		assertEquals(1, order2.getTotalItems());
	}

	@Test
	void testAddNewBeverageStringSizeIntBoolean() {
		order3.addNewBeverage("Pineapple", Size.SMALL, 5, false);
		assertEquals(1, order3.getTotalItems());
	}

}
