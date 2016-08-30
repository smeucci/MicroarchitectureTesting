package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.Or;
import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;

public class OrTest {

	private Component x;
	private Component y;
	private Component or;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
		
	@Before
	public void setup() throws Exception {
		ConcreteExprBuilder builder = new ConcreteExprBuilder();
		x = builder.BuildVariable("X", true);
		y = builder.BuildVariable("Y", false);
		or = builder.BuildOr(x, y);
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
	 * Testing Or constructor
	 * 
	 */
	@Test
	public void ConstructorTest() {
		or = new Or();
		assertEquals("OR name not initialed correctly.", " OR ", or.getName());
	}
	
	
	/**
	 * Testing add method
	 * 
	 */
	@Test
	public void addTest() {
		Component or = new Or();
		or.add(x);
		or.add(y);
		assertEquals("Add method not working correctly.", "", output.toString());
	}
	
	
	/**
	 * Testing draw method
	 * 
	 */
	@Test
	public void drawTest() {
		or.draw();
		assertEquals("OR expression not drawn correctly.", "X:true OR Y:false", output.toString());
	}
	
	
	/**
	 * Testing evaluate method
	 * 
	 */
	@Test
	public void evaluateTest() {
		assertEquals("OR expression not evaluated correctly.", true, or.evaluate());
	}
}
