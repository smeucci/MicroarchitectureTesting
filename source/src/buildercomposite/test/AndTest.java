package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.And;
import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;

public class AndTest {

	private Component x;
	private Component y;
	private Component and;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
		
	@Before
	public void setup() throws Exception {
		ConcreteExprBuilder builder = new ConcreteExprBuilder();
		x = builder.BuildVariable("X", true);
		y = builder.BuildVariable("Y", false);
		and = builder.BuildAnd(x, y);
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
	 * Testing and constructor
	 * 
	 */
	@Test
	public void ConstructorTest() {
		and = new And();
		assertEquals("AND name not initialed correctly.", " AND ", and.getName());
	}
	
	
	/**
	 * Testing add method
	 * 
	 */
	@Test
	public void addTest() {
		Component and = new And();
		and.add(x);
		and.add(y);
		assertEquals("Add method not working correctly.", "", output.toString());
	}
	
	
	/**
	 * Testing draw method
	 * 
	 */
	@Test
	public void drawTest() {
		and.draw();
		assertEquals("AND expression not drawn correctly.", "X:true AND Y:false", output.toString());
	}
	
	
	/**
	 * Testing evaluate method
	 * 
	 */
	@Test
	public void evaluateTest() {
		assertEquals("AND expression not evaluated correctly.", false, and.evaluate());
	}
}
