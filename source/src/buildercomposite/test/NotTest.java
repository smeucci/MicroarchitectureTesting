package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;
import buildercomposite.Not;

public class NotTest {

	private Component x;
	private Component not;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception {
		ConcreteExprBuilder builder = new ConcreteExprBuilder();
		x = builder.BuildVariable("X", true);
		not = builder.BuildNot(x);
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
	 * Testing and constructor. The name of the component must be set properly.
	 * 
	 */
	@Test
	public void ConstructorTest() {
		not = new Not();
		assertEquals("NOT name not initialed correctly.", "NOT", not.getName());
	}
	
	
	/**
	 * Testing add method. The component should become the child attribute. It should not give an output message.
	 * 
	 */
	@Test
	public void addTest() {
		Component not = new Not();
		not.add(x);
		assertEquals("Add method not working correctly.", "", output.toString());
	}
	
	
	/**
	 * Testing draw method. The component must be printed as expected.
	 * 
	 */
	@Test
	public void drawTest() {
		not.draw();
		assertEquals("NOT expression not drawn correctly.", "NOT(X:true)", output.toString());
	}
	
	
	/**
	 * Testing evaluate method. The Component should be evaluated correctly.
	 * 
	 */
	@Test
	public void evaluateTest() {
		assertEquals("NOT expression not evaluated correctly.", false, not.evaluate());
	}

}
