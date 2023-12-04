/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: JUnit test of enum class of the Type
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

class TypeTestStudent {
	
	String type;
	Type[] types;

	@BeforeEach
	void setUp() throws Exception {
		type = "COFFEE";
		types = Type.values();
	}

	@AfterEach
	void tearDown() throws Exception {
		type = null;
		types = null;
	}

	@Test
	void test() {
		assertEquals(Type.COFFEE, Type.valueOf(type));
		assertEquals(Type.values()[2], Type.ALCOHOL);
	}

}
