package buildercomposite.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;
import buildercomposite.ValueInitialiser;

public class ConcreteExprBuilderTest {

	private ConcreteExprBuilder builder;
	
	@Mock
	ValueInitialiser mockInit;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		builder = new ConcreteExprBuilder();
	}
	
	
	/**
	 * Testing variable creation
	 * 
	 */
	@Test
	public void BuildVariableTest() {
		
		when(mockInit.initValue()).thenReturn(true);
		Component x = builder.BuildVariable("X", mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		Component y = builder.BuildVariable("Y", mockInit.initValue());
		
		assertEquals("X value does not evaluate corretcly.", true, x.evaluate());
		assertEquals("Y value does not evaluate correctly.", false, y.evaluate());
		
	}
	
	
	/**
	 * Testing AND expression
	 * 
	 */
	@Test
	public void BuildAndTest() {
		
		// true and true -> true
		when(mockInit.initValue()).thenReturn(true);
		Component x = builder.BuildVariable("X", mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		Component y = builder.BuildVariable("Y", mockInit.initValue());
		
		Component and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", true, and.evaluate());
		
		// true and false -> false
		when(mockInit.initValue()).thenReturn(true);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		
		and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", false, and.evaluate());
		
		// false and true -> false
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		y.setValue(mockInit.initValue());
		
		and = builder.BuildAnd(x, y);
		assertEquals("AND expression does not evaluate corretly.", false, and.evaluate());
		
		// false and false -> false
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		
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
		when(mockInit.initValue()).thenReturn(true);
		Component x = builder.BuildVariable("X", mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		Component y = builder.BuildVariable("Y", mockInit.initValue());
		
		Component or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// true and false -> true
		when(mockInit.initValue()).thenReturn(true);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// false and true -> true
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		y.setValue(mockInit.initValue());
		
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		// false and false -> false
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", false, or.evaluate());
		
	}
	
	
	/**
	 * Testing NOT expression.
	 * 
	 */
	@Test
	public void BuildNotTest() {
		
		when(mockInit.initValue()).thenReturn(true);
		Component x = builder.BuildVariable("X", mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		Component y = builder.BuildVariable("Y", mockInit.initValue());
		
		Component or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		Component not = builder.BuildNot(or);
		assertEquals("NOT expression does not evaluate corretly.", false, not.evaluate());
		
		// true and false -> true
		when(mockInit.initValue()).thenReturn(true);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		not = builder.BuildNot(or);
		assertEquals("NOT expression does not evaluate corretly.", false, not.evaluate());
		
		// false and true -> true
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(true);
		y.setValue(mockInit.initValue());
		
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", true, or.evaluate());
		
		not = builder.BuildNot(or);
		assertEquals("NOT expression does not evaluate corretly.", false, not.evaluate());
		
		// false and false -> false
		when(mockInit.initValue()).thenReturn(false);
		x.setValue(mockInit.initValue());
		
		when(mockInit.initValue()).thenReturn(false);
		y.setValue(mockInit.initValue());
		
		or = builder.BuildOr(x, y);
		assertEquals("OR expression does not evaluate corretly.", false, or.evaluate());
		
		not = builder.BuildNot(or);
		assertEquals("NOT expression does not evaluate corretly.", true, not.evaluate());
		
	}
	

	/**
	 * Testing Parenthesis
	 * 
	 */
	@Test
	public void BuildParenthesisTest() {
		
		when(mockInit.initValue()).thenReturn(true);
		Component x = builder.BuildVariable("X", mockInit.initValue());
		
		Component par = builder.BuildParenthesis(x);
		assertEquals("Parenthesis does not evaluate correctly with variable.", true, par.evaluate());
		
		when(mockInit.initValue()).thenReturn(false);
		Component y = builder.BuildVariable("Y", mockInit.initValue());
		par = builder.BuildParenthesis(y);
		assertEquals("Parenthesis does not evaluate correctly with variable.", false, par.evaluate());
		
		Component and = builder.BuildAnd(x, y);
		par = builder.BuildParenthesis(and);
		assertEquals("Parenthesis does not evaluate corretly with AND expression", false, par.evaluate());
		
		Component or = builder.BuildOr(x, y);
		par = builder.BuildParenthesis(or);
		assertEquals("Parenthesis does not evaluate corretly with OR expression", true, par.evaluate());
		
		Component not = builder.BuildNot(or);
		par = builder.BuildParenthesis(not);
		assertEquals("Parenthesis does not evaluate corretly with OR expression", false, par.evaluate());
		
	}
	

}
