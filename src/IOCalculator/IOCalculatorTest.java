package IOCalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class IOCalculatorTest {

	static IOCalculator ui;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ui = new IOCalculator("input.txt", "output.txt");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ui.pw.close();
		ui.writer.close();
	}

	@Test
	public void CalculateAddition() {
		double expected;
		double actual;
		
		try {
			expected = 5;
			actual = ui.Calculate(2, 3, "+");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 15;
			actual = ui.Calculate(10, 5, "+");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 0;
			actual = ui.Calculate(0, 0, "+");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 0;
			actual = ui.Calculate(-1, 1, "+");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
	}
	
	@Test
	public void CalculateSubtraction() {
		double expected;
		double actual;
		
		try {
			expected = -1;
			actual = ui.Calculate(2, 3, "-");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 0;
			actual = ui.Calculate(0, 0, "+");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 9;
			actual = ui.Calculate(10, 1, "-");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
	}
	
	@Test
	public void CalculateDivision() {
		double expected;
		double actual;
		
		try {
			expected = 2.0/3;
			actual = ui.Calculate(2.0, 3, "/");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 1.0/0;
			actual = ui.Calculate(1, 0, "/");
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 10;
			actual = ui.Calculate(10, 1, "/");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
	}
	
	@Test
	public void CalculateMultiplication() {
		double expected;
		double actual;
		
		try {
			expected = 6;
			actual = ui.Calculate(2.0, 3, "*");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 0;
			actual = ui.Calculate(1, 0, "*");
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 10;
			actual = ui.Calculate(10, 1, "*");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
	}
	
	@Test
	public void CalculatePow() {
		double expected;
		double actual;
		
		try {
			expected = 8;
			actual = ui.Calculate(2.0, 3, "^");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 1;
			actual = ui.Calculate(1, 0, "*");
		} catch (Exception e) {
			fail("Encountered Exception");
		}
		
		try {
			expected = 10;
			actual = ui.Calculate(10, 1, "^");
			assertTrue(expected == actual);
		} catch (Exception e) {
			fail("Encountered Exception");
		}
	}
	
	@Test
	public void CalculateInvalid() {
		double expected;
		double actual;
		
		try {
			expected = 8;
			actual = ui.Calculate(2.0, 3, "");
			fail("did not encounter exception");
		} catch (Exception e) {
		}
	}
}
