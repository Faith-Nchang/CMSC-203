/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol class JUnit test
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

class AlcoholTestStudent {

	Alcohol alcohol1;
	Alcohol alcohol2;
	Alcohol alcohol3;
	
	@BeforeEach
	void setUp() throws Exception {
		alcohol1 = new Alcohol("Wine", Size.SMALL, true);
		alcohol2 = new Alcohol("Beer", Size.MEDIUM, false);
		alcohol3 = new Alcohol("Chicha", Size.LARGE, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		alcohol1 = null;
		alcohol2 = null;
		alcohol3= null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.6, alcohol1.calcPrice(), 0.00001);
		assertEquals(3.0, alcohol2.calcPrice(), 0.00001);
		assertEquals(4.6, alcohol3.calcPrice(), 0.0001);
	}

	@Test
	void testToString() {
		assertEquals("Wine,SMALL,true,2.6", alcohol1.toString());
		assertEquals("Beer,MEDIUM,false,3.0", alcohol2.toString());
		assertEquals("Chicha,LARGE,true,4.6", alcohol3.toString());
	}

//	@Test
//	void testAlcohol() {
//		fail("Not yet implemented");
//	}

	@Test
	void testEqualsAlcohol() {
		assertFalse(alcohol1.equals(alcohol2));
		assertTrue(alcohol3.equals(alcohol3));
	}

	@Test
	void testIsWeekend() {
		assertTrue(alcohol1.isWeekend());
		assertFalse(alcohol2.isWeekend());
	}

	@Test
	void testSetIsWeekend() {
		alcohol3.setIsWeekend(false);
		alcohol2.setIsWeekend(true);
		
		assertTrue(alcohol2.getIsWeekend());
		assertFalse(alcohol3.getIsWeekend());
	}

	@Test
	void testGetIsWeekend() {
		assertTrue(alcohol1.getIsWeekend());
		assertFalse(alcohol2.getIsWeekend());
		assertTrue(alcohol3.getIsWeekend());
	}

	@Test
	void testGetBevName() {
		assertEquals("Wine", alcohol1.getBevName());
		assertEquals("Beer", alcohol2.getBevName());
		assertEquals("Chicha", alcohol3.getBevName());
	}

	@Test
	void testGetSize() {
		assertEquals(Size.SMALL, alcohol1.getSize());
	}

	@Test
	void testGetType() {
		assertEquals(Type.ALCOHOL, alcohol1.getType());
	}

	@Test
	void testSetBevName() {
		alcohol1.setBevName("Black Legend");
		assertEquals("Black Legend", alcohol1.getBevName());
	}

	@Test
	void testSetType() {
		alcohol3.setType(Type.SMOOTHIE);
		assertEquals(Type.SMOOTHIE, alcohol3.getType());
	}

	@Test
	void testSetSize() {
		alcohol2.setSize(Size.LARGE);
		assertEquals(Size.LARGE, alcohol2.getSize());
	}

	@Test
	void testGetBasePrice() {
		assertEquals(2.0, alcohol1.getBasePrice(), 0.000001);
		assertEquals(2.0, alcohol2.getBasePrice(), 0.000001);
		assertEquals(2.0, alcohol3.getBasePrice(), 0.000001);
	}

	@Test
	void testEqualsBeverage() {
		assertFalse(alcohol1.equals(alcohol2));
		assertFalse(alcohol2.equals(alcohol3));
	}

	@Test
	void testAddSizePrice() {
		assertEquals(2.0, alcohol1.addSizePrice(), 0.0001);
		assertEquals(3.0, alcohol2.addSizePrice(), 0.0001);
		assertEquals(4.0, alcohol3.addSizePrice(), 0.0001);
	}

}
