/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Coffee class JUnit test
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

class CoffeeTestStudent {
	
	Coffee coffee1;
	Coffee coffee2;
	Coffee coffee3;

	@BeforeEach
	void setUp() throws Exception {
		coffee1 = new Coffee("Cappuccino", Size.SMALL, false, false);
		coffee2 = new Coffee("Black coffee", Size.MEDIUM, true, false);
		coffee3 = new Coffee("Espresso", Size.LARGE, true, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		coffee1 = null;
		coffee2 = null;
		coffee3= null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.0, coffee1.calcPrice(), 0.0001);
		assertEquals(3.5, coffee2.calcPrice(), 0.0001);
		assertEquals(5.0, coffee3.calcPrice(), 0.0001);
	}

	@Test
	void testToString() {
		assertEquals("Cappuccino,SMALL,false,false,2.0", coffee1.toString());
		assertEquals("Black coffee,MEDIUM,true,false,3.5", coffee2.toString());
	
	}

	@Test
	void testEqualsCoffee() {
		assertFalse(coffee1.equals(coffee3));
		assertTrue(coffee2.equals(coffee2));
	}

	@Test
	void testGetExtraShot() {
		assertFalse(coffee1.getExtraShot());
		assertTrue(coffee2.getExtraShot());
		assertTrue(coffee3.getExtraShot());
	}

	@Test
	void testGetExtraSyrup() {
		assertFalse(coffee1.getExtraSyrup());
		assertFalse(coffee2.getExtraSyrup());
		assertTrue(coffee3.getExtraSyrup());
	}

	@Test
	void testSetExtraShot() {
		coffee2.setExtraShot(false);
		assertFalse(coffee2.getExtraShot());
	}

	@Test
	void testSetExtraSyrup() {
		coffee1.setExtraSyrup(true);
		assertTrue(coffee1.getExtraSyrup());
	}

	@Test
	void testGetBevName() {
		assertEquals("Cappuccino", coffee1.getBevName());
		assertEquals("Black coffee", coffee2.getBevName());
		assertEquals("Espresso", coffee3.getBevName());
	}

	@Test
	void testGetSize() {
		assertEquals(Size.SMALL, coffee1.getSize());
		assertEquals(Size.MEDIUM, coffee2.getSize());
		assertEquals(Size.LARGE, coffee3.getSize());
	}

	@Test
	void testGetType() {
		assertEquals(Type.COFFEE, coffee1.getType());
		assertEquals(Type.COFFEE, coffee2.getType());
		assertEquals(Type.COFFEE, coffee3.getType());
	}

	@Test
	void testSetBevName() {
		coffee2.setBevName("Latte");
		assertEquals("Latte", coffee2.getBevName());
	}

	@Test
	void testSetType() {
		coffee3.setType(Type.ALCOHOL);
		assertEquals(Type.ALCOHOL, coffee3.getType());
	}

	@Test
	void testSetSize() {
		coffee1.setSize(Size.LARGE);
		assertEquals(Size.LARGE, coffee1.getSize());
	}

	@Test
	void testGetBasePrice() {
		assertEquals(2.0, coffee1.getBasePrice(), 0.0001);
		assertEquals(2.0, coffee2.getBasePrice(), 0.0001);
		assertEquals(2.0, coffee3.getBasePrice(), 0.0001);
	}

	@Test
	void testEqualsBeverage() {
		assertTrue(coffee1.equals(coffee1));
	}

	@Test
	void testAddSizePrice() {
		assertEquals(2.0, coffee1.addSizePrice(), 0.001);
		assertEquals(3.0, coffee2.addSizePrice(), 0.001);
		assertEquals(4.0, coffee3.addSizePrice(), 0.001);
	}

}
