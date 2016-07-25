package buildercomposite.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;

public class ConcreteExprBuilderTest {

	private ConcreteExprBuilder builder;
	
	@Before
	public void setup() throws Exception {
		builder = new ConcreteExprBuilder();
	}
	
	
	/**
	 * Testing variable creation
	 * 
	 */
	@Test
	public void BuildVariableTest() {
		
		Component x = builder.BuildVariable("X", true);
		Component y = builder.BuildVariable("Y", false);
		
		assertEquals("X value does not evaluate corretcly.", x.evaluate(), true);
		assertEquals("Y value does not evaluate correctly.", y.evaluate(), false);
		
	}
	
	
	/**
	 * Testing AND expression
	 * 
	 */
	@Test
	public void BuildAndTest() {
		
		// true and true -> true
		Component x = builder.BuildVariable("X", true);
		Component y = builder.BuildVariable("Y", true);
		Component and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", true, and.evaluate());
		
		// true and false -> false
		x.setValue(true);
		y.setValue(false);
		and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", false, and.evaluate());
		
		// false and true -> false
		x.setValue(false);
		y.setValue(true);
		and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", false, and.evaluate());
		
		// false and false -> false
		x.setValue(false);
		y.setValue(false);
		and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", false, and.evaluate());
		
	}
	
	
	/**
	 * Testing OR expression
	 * 
	 */
	@Test
	public void BuildOrTest() {
		
		// true and true -> true
		Component x = builder.BuildVariable("X", true);
		Component y = builder.BuildVariable("Y", true);
		Component or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// true and false -> true
		x.setValue(true);
		y.setValue(false);
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// false and true -> true
		x.setValue(false);
		y.setValue(true);
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// false and false -> false
		x.setValue(false);
		y.setValue(false);
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", false, or.evaluate());
		
	}
	
	
	/**
	 * Testing Parenthesis
	 * 
	 */
	@Test
	public void BuildParenthesisTest() {
		
		Component x = builder.BuildVariable("X", true);
		Component par = builder.BuildParenthesis(x);
		assertEquals("Parenthesis does not evaluate correctly with variable.", true, par.evaluate());
		
		Component y = builder.BuildVariable("Y", false);
		par = builder.BuildParenthesis(y);
		assertEquals("Parenthesis does not evaluate correctly with variable.", false, par.evaluate());
		
		Component and = builder.BuildAnd(x, y);
		par = builder.BuildParenthesis(and);
		assertEquals("Parenthesis does not evaluate corretly with AND expression", false, par.evaluate());
		
		Component or = builder.BuildOr(x, y);
		par = builder.BuildParenthesis(or);
		assertEquals("Parenthesis does not evaluate corretly with OR expression", true, par.evaluate());
		
	}
	

}
