package IOCalculator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class IOCalculatorE2ETest {

	static IOCalculator ui;
	Scanner output;
	Scanner expected;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ui = new IOCalculator("input.txt", "output.txt");
	}

	@Test
	public void E2ETest() throws IOException {
		ui.ProcessFile();
		ui.pw.close();
		ui.writer.close();
		output = new Scanner(new File("output.txt"));
		expected = new Scanner(new File("expected.txt"));
		int curr = 0;
		
		while(output.hasNextLine() && expected.hasNextLine()) {
			if(!output.nextLine().equals(expected.nextLine())) {
				fail("output does not equal expected at line: " + curr);
			}
		}
		if(output.hasNextLine()) {
			fail("output has more lines than expected");
		}
		if(expected.hasNextLine()) {
			fail("output has less lines than expected");
		}
	}

}
