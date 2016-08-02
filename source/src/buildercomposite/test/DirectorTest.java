package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;

public class DirectorTest {

	private ConcreteExprBuilder builder;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception {
		builder = new ConcreteExprBuilder();
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
		
		Component varx = builder.BuildVariable("X", true);
		assertEquals("Variable does not evaluate correctly.", true, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", true);
    	assertEquals("Variable does not evaluate correctly.", true, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", true, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", true, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", true);
    	assertEquals("Variable does not evaluate correctly.", true, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", false, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", true, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:true) OR NOT(Z:true) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, true, false)
	 * 
	 */
	@Test
	public void ConstructExprTest2() {
		
		Component varx = builder.BuildVariable("X", true);
		assertEquals("Variable does not evaluate correctly.", true, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", true);
    	assertEquals("Variable does not evaluate correctly.", true, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", true, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", true, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", false);
    	assertEquals("Variable does not evaluate correctly.", false, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", true, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", true, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:true) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, false, true)
	 * 
	 */
	@Test
	public void ConstructExprTest3() {
		
		Component varx = builder.BuildVariable("X", true);
		assertEquals("Variable does not evaluate correctly.", true, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", false);
    	assertEquals("Variable does not evaluate correctly.", false, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", true);
    	assertEquals("Variable does not evaluate correctly.", true, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", false, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", false, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:false) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (true, false, false)
	 * 
	 */
	@Test
	public void ConstructExprTest4() {
		
		Component varx = builder.BuildVariable("X", true);
		assertEquals("Variable does not evaluate correctly.", true, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", false);
    	assertEquals("Variable does not evaluate correctly.", false, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", false);
    	assertEquals("Variable does not evaluate correctly.", false, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", true, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", true, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:true AND Y:false) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, true, true)
	 * 
	 */
	@Test
	public void ConstructExprTest5() {
		
		Component varx = builder.BuildVariable("X", false);
		assertEquals("Variable does not evaluate correctly.", false, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", true);
    	assertEquals("Variable does not evaluate correctly.", true, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", true);
    	assertEquals("Variable does not evaluate correctly.", true, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", false, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", false, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:true) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, true, false)
	 * 
	 */
	@Test
	public void ConstructExprTest6() {
		
		Component varx = builder.BuildVariable("X", false);
		assertEquals("Variable does not evaluate correctly.", false, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", true);
    	assertEquals("Variable does not evaluate correctly.", true, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", false);
    	assertEquals("Variable does not evaluate correctly.", false, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", true, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", true, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:true) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, false, true)
	 * 
	 */
	@Test
	public void ConstructExprTest7() {
		
		Component varx = builder.BuildVariable("X", false);
		assertEquals("Variable does not evaluate correctly.", false, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", false);
    	assertEquals("Variable does not evaluate correctly.", false, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", true);
    	assertEquals("Variable does not evaluate correctly.", true, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", false, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", false, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:false) OR NOT(Z:true) --> evaluation: false\n", output.toString());
    	
	}
	
	/**
	 * Testing the construction of a generic boolean expression, with step by step evaluation check (false, false, false)
	 * 
	 */
	@Test
	public void ConstructExprTest8() {
		
		Component varx = builder.BuildVariable("X", false);
		assertEquals("Variable does not evaluate correctly.", false, varx.evaluate());
		
    	Component vary = builder.BuildVariable("Y", false);
    	assertEquals("Variable does not evaluate correctly.", false, vary.evaluate());
    	
    	Component and = builder.BuildAnd(varx, vary);
    	assertEquals("AND expression does not evaluate correctly.", false, and.evaluate());
    	
    	Component par = builder.BuildParenthesis(and);
    	assertEquals("Parenthesis does not evaluate correctly.", false, par.evaluate());
    	    	
    	Component varz = builder.BuildVariable("Z", false);
    	assertEquals("Variable does not evaluate correctly.", false, varz.evaluate());
    	
    	Component not = builder.BuildNot(varz);
    	assertEquals("NOT expression does not evaluate correctly.", true, not.evaluate());
    	
    	Component or = builder.BuildOr(par, not);
    	assertEquals("OR expression does not evaluate correctly.", true, or.evaluate());
    	
    	System.out.print("# "); or.draw(); System.out.println(" --> evaluation: " + or.evaluate());
    	assertEquals("Draw and print not working properly.", "# (X:false AND Y:false) OR NOT(Z:false) --> evaluation: true\n", output.toString());
    	
	}
	
}
