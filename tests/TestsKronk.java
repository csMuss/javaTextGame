package textGame.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textGame.Kronk;

public class TestsKronk {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	// Test values
	
	private String printTest = "TestPrint!";
	
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));		
	}
	
	@Test
	public void testPrint() {
	    Kronk.print(printTest);
	    assertEquals(printTest, outContent.toString().trim());
	}
	
	@Test
	public void testErrPrint() {
	    Kronk.errPrint(printTest);
	    assertEquals(printTest, errContent.toString().trim());
	}
	
	@After
	public void tearDown() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
}
