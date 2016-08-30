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

import buildercomposite.*;

public class FunctionalityTest {

	@Mock ValueInitialiser mockInit;
	
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
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
	public void AddingComponentToComposite() throws InvalidComponentAddingException{
		
		ExprBuilder builder = new ConcreteExprBuilder();
		Component varx = builder.BuildVariable("X", true);
		Component vary = builder.BuildVariable("Y", false);
		
		//ADD method for classes that extend Composite. The add method is called inside builder.Build..
		builder.BuildAnd(varx, vary);
		builder.BuildOr(varx, vary);
		builder.BuildNot(varx);
		builder.BuildParenthesis(varx);
		
	}
	
	
	/*
	 * Title: Concrete Expression Builder.
	 * 
	 * Description: When an expression (Variable, And, Or, Not, Parenthesis) is built, it must have the expected attributes.
	 * 
	 */
	@Test
	public void ConcreteExpressionBuilderTest() {
		
		ExprBuilder builder = new ConcreteExprBuilder();
		
		Component varx = builder.BuildVariable("X", true);
		varx.draw();
		assertEquals("X:true", output.toString());
		
		output.reset();
		Component vary = builder.BuildVariable("Y", false);
		vary.draw();
		assertEquals("Y:false", output.toString());
		
		output.reset();
		Component and = builder.BuildAnd(varx, vary);
		and.draw();
		assertEquals("X:true AND Y:false", output.toString());
		
		output.reset();
		Component or = builder.BuildOr(varx, vary);
		or.draw();
		assertEquals("X:true OR Y:false", output.toString());
		
		output.reset();
		Component not = builder.BuildNot(varx);
		not.draw();
		assertEquals("NOT X:true", output.toString());
		
		output.reset();
		Component par = builder.BuildParenthesis(varx);
		par.draw();
		assertEquals("(X:true)", output.toString());
		
	}
	
	
	/*
	 * Title: Expression Evaluation.
	 * 
	 * Description: A generic boolean expression must be correctly evaluated for all possible variables values. The values are
	 * initialised thanks to the mocked class ValueInitialiser and its method initValue().
	 * 
	 */
	@Test
	public void ExpressionEvaluationAndOutputTest() {
		
		ExprBuilder builder = new ConcreteExprBuilder();
		Director director = new Director(builder);
		director.setValueInitialiser(mockInit);
		
		boolean[] x_values = {true, true, true, true, false, false, false, false};
		boolean[] y_values = {true, true, false, false, true, true, false, false};
		boolean[] z_values = {true, false, true, false, true, false, true, false};
		
		boolean[] evaluations = {true, true, false, true, false, true, false, true};
		
		String[] outputs = {"# (X:true AND Y:true) OR NOT Z:true --> evaluation: true\n",
							"# (X:true AND Y:true) OR NOT Z:false --> evaluation: true\n",
							"# (X:true AND Y:false) OR NOT Z:true --> evaluation: false\n",
							"# (X:true AND Y:false) OR NOT Z:false --> evaluation: true\n",
							"# (X:false AND Y:true) OR NOT Z:true --> evaluation: false\n",
							"# (X:false AND Y:true) OR NOT Z:false --> evaluation: true\n",
							"# (X:false AND Y:false) OR NOT Z:true --> evaluation: false\n",
							"# (X:false AND Y:false) OR NOT Z:false --> evaluation: true\n",
							};
			
		for (int i = 0; i < evaluations.length; i++) {
			
			when(director.getValueInitialiser().initValue()).thenReturn(x_values[i]);
			Boolean x = director.getValueInitialiser().initValue();
			
			when(director.getValueInitialiser().initValue()).thenReturn(y_values[i]);
			Boolean y = director.getValueInitialiser().initValue();
			
			when(director.getValueInitialiser().initValue()).thenReturn(z_values[i]);
			Boolean z = director.getValueInitialiser().initValue();
			
			assertEquals("Expression NOT evaluated correctly.", evaluations[i], director.ConstructExpr(x, y, z));	
	    	assertEquals("Draw and print not working properly.", outputs[i], output.toString());
	    	
	    	output.reset();
	    	
		}
		
	}

}
