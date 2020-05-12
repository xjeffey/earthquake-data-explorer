package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class consoleInterfaceTest {

	//testing to see if dashes match what we want string to look like
	@Test
	public void menuSpaceTest() {
		assertEquals("Strings should match", "--------help--------", consoleInterface.menuSpace("help"));
	}
	
	
}
