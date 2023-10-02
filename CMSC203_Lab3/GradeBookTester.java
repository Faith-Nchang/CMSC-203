import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	GradeBook grade1, grade2;
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade1.addScore(50.0);
		grade1.addScore(79.0);
		
		grade2 = new GradeBook(5);
		grade2.addScore(100.0);
		grade2.addScore(89.0);
		grade2.addScore(57.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1 = null;
		grade2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("50.0 79.0"));
		assertTrue(grade2.toString().equals("100.0 89.0 57.0"));
		
	}

	@Test
	void testSum() {
		assertEquals(129, grade1.sum(), 0.0001);
		assertEquals(246, grade2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(50.0, grade1.minimum(), 0.001);
		assertEquals(57.0, grade2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(79.0, grade1.finalScore(), 0.0001);
		assertEquals(189.0, grade2.finalScore(), 0.0001);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, grade1.getScoreSize(), 0.0001);
		assertEquals(3, grade2.getScoreSize(), 0.0001);
	}

	@Test
	void testToString() {
		assertTrue(grade1.toString().equals("50.0 79.0"));
		assertTrue(grade2.toString().equals("100.0 89.0 57.0"));
	}		

}
