package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;
import buildercomposite.Or;
import buildercomposite.Parenthesis;

public class ParenthesisTest {

	private Component x;
	private Component par;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception {
		ConcreteExprBuilder builder = new ConcreteExprBuilder();
		x = builder.BuildVariable("X", true);
		par = builder.BuildParenthesis(x);
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
		par = new Parenthesis();
		assertEquals("Parenthesis name not initialed correctly.", "PARENTHESIS", par.getName());
	}
	
	
	/**
	 * Testing add method
	 * 
	 */
	@Test
	public void addTest() {
		Component par = new Parenthesis();
		par.add(x);
		assertEquals("Add method not working correctly.", "", output.toString());
	}
	
	
	/**
	 * Testing draw method
	 * 
	 */
	@Test
	public void drawTest() {
		par.draw();
		assertEquals("Parenthesis expression not drawn correctly.", "(X:true)", output.toString());
	}
	
	
	/**
	 * Testing evaluate method
	 * 
	 */
	@Test
	public void evaluateTest() {
		assertEquals("Parethesis expression not evaluated correctly.", true, par.evaluate());
	}

}
