package buildercomposite.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import buildercomposite.ConcreteExprBuilder;
import buildercomposite.Director;
import buildercomposite.ValueInitialiser;

public class DirectorTest {

	private Director director;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Mock
	ValueInitialiser mockInit;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		director = new Director(new ConcreteExprBuilder());
		director.setValueInitialiser(mockInit);
	}
		
	@Before
	public void setupStream() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void clearStream() {
		System.setOut(null);
	}
	
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, true, true)
	 * 
	 */
	@Test
	public void ConstructExprTest1() {
	
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", true, director.ConstructExpr(x, y, z));	
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:true) OR NOT(Z:true) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, true, false)
	 * 
	 */
	@Test
	public void ConstructExprTest2() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", true, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:true) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, false, true)
	 * 
	 */
	@Test
	public void ConstructExprTest3() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", false, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:false) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, false, false)
	 * 
	 */
	@Test
	public void ConstructExprTest4() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", true, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:false) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, true, true)
	 * 
	 */
	@Test
	public void ConstructExprTest5() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", false, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:true) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, true, false)
	 * 
	 */
	@Test
	public void ConstructExprTest6() {

		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", true, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:true) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, false, true)
	 * 
	 */
	@Test
	public void ConstructExprTest7() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(true);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", false, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:false) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, false, false)
	 * 
	 */
	@Test
	public void ConstructExprTest8() {
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean x = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean y = director.getValueInitialiser().initValue();
		
		when(director.getValueInitialiser().initValue()).thenReturn(false);
		Boolean z = director.getValueInitialiser().initValue();
		
		assertEquals("Expression NOT evaluated correctly.", true, director.ConstructExpr(x, y, z));
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:false) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
}
