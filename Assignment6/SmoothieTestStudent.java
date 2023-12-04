/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Smoothie class JUnit test
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

class SmoothieTestStudent {
	Smoothie smoothie1;
	Smoothie smoothie2;

	@BeforeEach
	void setUp() throws Exception {
		smoothie1 = new Smoothie("Blueberry", Size.MEDIUM, 2, false);
		smoothie2 = new Smoothie("Strawberry", Size.LARGE, 4, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		smoothie1 = null;
		smoothie2 =null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(4, smoothie1.calcPrice());
		assertEquals(7.5, smoothie2.calcPrice());
	}

	@Test
	void testToString() {
		assertEquals("Blueberry,MEDIUM,false,2,4.0", smoothie1.toString());
		assertEquals("Strawberry,LARGE,true,4,7.5", smoothie2.toString());
	}

	@Test
	void testEqualsSmoothie() {
		assertFalse(smoothie1.equals(smoothie2));
		assertTrue(smoothie2.equals(smoothie2));
	}

	@Test
	void testGetAddProtein() {
		assertFalse(smoothie1.getAddProtein());
		assertTrue(smoothie2.getAddProtein());
	}

	@Test
	void testGetNumOfFruits() {
		assertEquals(2, smoothie1.getNumOfFruits());
		assertEquals(4, smoothie2.getNumOfFruits());
	}

	@Test
	void testSetAddProtein() {
		smoothie1.setAddProtein(true);
		assertTrue(smoothie1.getAddProtein());
	}

	@Test
	void testSetNumOfFruits() {
		smoothie2.setNumOfFruits(3);
		assertEquals(3, smoothie2.getNumOfFruits());
	}

	@Test
	void testGetBevName() {
		assertEquals("Blueberry", smoothie1.getBevName());
		assertEquals("Strawberry", smoothie2.getBevName());
	}

	@Test
	void testGetSize() {
		assertEquals(Size.MEDIUM, smoothie1.getSize());
		assertEquals(Size.LARGE, smoothie2.getSize());
	}

	@Test
	void testGetType() {
		assertEquals(Type.SMOOTHIE, smoothie1.getType());
		assertEquals(Type.SMOOTHIE, smoothie2.getType());
	}

	@Test
	void testSetBevName() {
		smoothie1.setBevName("Juice");
		assertEquals("Juice", smoothie1.getBevName());
		
	}

	@Test
	void testSetType() {
		smoothie2.setType(Type.COFFEE);
		assertEquals(Type.COFFEE, smoothie2.getType());
	}

	@Test
	void testSetSize() {
		smoothie1.setSize(Size.SMALL);
		assertEquals(Size.SMALL, smoothie1.getSize());
	}

	@Test
	void testGetBasePrice() {
		assertEquals(2.0, smoothie1.getBasePrice());
		assertEquals(2.0, smoothie2.getBasePrice());
	}

	@Test
	void testEqualsBeverage() {
		assertFalse(smoothie1.equals(smoothie2));
	}

	@Test
	void testAddSizePrice() {
		assertEquals(3.0, smoothie1.addSizePrice());
		assertEquals(4.0, smoothie2.addSizePrice());
	}

}
