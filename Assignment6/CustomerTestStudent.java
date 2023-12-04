/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Customer class JUnit test
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

class CustomerTestStudent {
	Customer customer1;
	Customer customer2;

	@BeforeEach
	void setUp() throws Exception {
		customer1 = new Customer("Faith Fru Nchang", 18);
		customer2 = new Customer(customer1);
	}

	@AfterEach
	void tearDown() throws Exception {
		customer1 = null;
		customer2 = null;
	}

	@Test
	void testGetName() {
		assertEquals("Faith Fru Nchang", customer1.getName());
		assertEquals("Faith Fru Nchang", customer2.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(18, customer1.getAge(), 0.0001);
		assertEquals(18, customer2.getAge(), 0.0001);	
		}

	@Test
	void testSetName() {
		customer1.setName("Jayden");
		customer2.setName("Harry");
		
		assertEquals("Jayden", customer1.getName());
		assertEquals("Harry", customer2.getName());
	}

	@Test
	void testSetAge() {
		customer1.setAge(55);
		customer2.setAge(23);
		assertEquals(55, customer1.getAge());
		assertEquals(23, customer2.getAge());
	}

	@Test
	void testToString() {
		assertEquals("Faith Fru Nchang,18", customer1.toString());
		assertEquals("Faith Fru Nchang,18", customer2.toString());
	}

}
