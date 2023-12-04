import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Junit test enum class of the Size
 * Due: 12/4/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Fru Nchang.
*/
class SizeTestStudent {
	String size;
	Size[] sizes;

	@BeforeEach
	void setUp() throws Exception {
		size = "MEDIUM";
		sizes = Size.values();
	}

	@AfterEach
	void tearDown() throws Exception {
		size =null;
		sizes = null;
	}

	@Test
	void test() {
		assertEquals(Size.MEDIUM, Size.valueOf(size));
		assertEquals(Size.LARGE, sizes[2]);
	}

}
