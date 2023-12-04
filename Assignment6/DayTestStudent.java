/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: JUnit test of enum class of the day
 * Due: 12/4/2023
 * Platform/compiler:Eclipse
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

class DayTestStudent {
	String day;
	Day[] days;

	@BeforeEach
	void setUp() throws Exception {
		day = "MONDAY";
		days = Day.values();
	}

	@AfterEach
	void tearDown() throws Exception {
		day = null;
		days = null;
	}

	@Test
	void test() {
		assertEquals(Day.MONDAY, Day.valueOf(day));
		assertEquals(Day.FRIDAY,  days[4]);
	}

}
