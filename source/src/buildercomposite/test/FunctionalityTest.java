package buildercomposite.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import buildercomposite.*;

public class FunctionalityTest {

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setupStream() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void clearStream() {
		System.setOut(null);
	}
	
	
	/*
	 * Title: Adding a component to a leaf.
	 * 
	 * Description: Variable extends the abstract class Component. When the add method of the Variable class 
	 * is called, an exception should be thrown.
	 * 
	 */
	@Test(expected=InvalidComponentAddingException.class)
	public void AddingComponentToLeafTest() throws InvalidComponentAddingException {
		
		ExprBuilder builder = new ConcreteExprBuilder();
		Component varx = builder.BuildVariable("X", true);
		Component vary = builder.BuildVariable("Y", false);
		
		// ADD method for variable
		varx.add(vary);
		
		
		
		
	}
	
	
	/*
	 * Title: Adding a component to a composite.
	 * 
	 * Description: Composite extends the abstract class Component. When the add method of the classes that extends the Composite class, the passed component(s)
	 * should be added to the children components list and no exception should be thrown.
	 * 
	 */
	@Test
	public void AddingComponentToComposite() {
		
		ExprBuilder builder = new ConcreteExprBuilder();
		Component varx = builder.BuildVariable("X", true);
		Component vary = builder.BuildVariable("Y", false);
		
		//ADD method for classes that extend Composite. The add method is called inside builder.Build..
		Component and = builder.BuildAnd(varx, vary);
		Component or = builder.BuildOr(varx, vary);
		Component not = builder.BuildNot(varx);
		Component parenthesis = builder.BuildParenthesis(varx);
		
	}
	
	
	/*
	 * Title: Concrete Expression Builder.
	 * 
	 * Description: When an expression (Variable, And, Or, Not, Parenthesis) is built, it must have the expected attributes.
	 * 
	 */
	@Test
	public void ConcreteExpressionBuilderTest() {
		
		
		
	}

}
