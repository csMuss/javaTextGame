package textGame.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textGame.Kronk;
import textGame.Movement.CommandLogic;

public class TestsKronk {
	
	// Setup tests
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	// Test values
	private String printTest = "TestPrint!";
	private int currentPos = 4;
	private CommandLogic cmd = new CommandLogic(printTest, currentPos);
	
	private String northInput = "north";
	private int northTest = 1;
	
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
	
	@Test 
	public void testDebugTP() {
		assertEquals(cmd.getNewPosition(), currentPos);
	}
	
	@Test 
	public void testDebugTPFail() {
		assertNotEquals(cmd.getNewPosition(), currentPos + 1);
	}
	
	@Test 
	public void testCMDLogic() {
		CommandLogic testNorth = cmd.checkCMD(northInput, northTest + 1);
		assertEquals(testNorth, testNorth);
	}
	
	@After
	public void tearDown() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
}
