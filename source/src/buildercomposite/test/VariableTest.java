package buildercomposite.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import buildercomposite.Component;
import buildercomposite.ConcreteExprBuilder;
import buildercomposite.Variable;

public class VariableTest {

	private Component variable;
	private ConcreteExprBuilder builder;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() throws Exception {
		builder = new ConcreteExprBuilder();
		variable = builder.BuildVariable("X", true);
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
	 * Testing variable concstructor
	 * 
	 */
	@Test
	public void ConstructorTest() {
		
		Component var = new Variable("X");
		assertEquals("Variable name not initialized correctly.", "X", var.getName());
		assertEquals("Variable value not initialized correctly.", null, var.getValue());
		
	}
	
	
	/**
	 * Testing getName method
	 * 
	 */
	@Test
	public void getNameTest() {	
		assertEquals("Variable name not correct.", "X", variable.getName());
	}
	
	
	/**
	 * Testing getValue method
	 * 
	 */
	@Test
	public void getValueTest() {	
		assertEquals("Variable value not correct.", true, variable.getValue());
	}
	
	
	/**
	 * Testing setValue method
	 * 
	 */
	@Test
	public void setValueTest() {
		assertEquals(true, variable.getValue());
		variable.setValue(false);
		assertEquals("setValue does not change variable value.", false, variable.getValue());
	}
	
	
	/**
	 * Testing evaluate method
	 * 
	 */
	@Test
	public void evaluateTest() {
		assertEquals("Variable not correctly evaluated.", variable.getValue(), variable.evaluate());
	}
	
	
	/**
	 * Testing draw method
	 * 
	 */
	@Test
	public void drawTest() {
		variable.draw();
		assertEquals("Variable not drawn correctly.", "X:true", output.toString());
	}
	
	
	/**
	 * Testing add method
	 * 
	 */
	@Test
	public void addTest() {
		variable.add(builder.BuildVariable("Y", false));
		assertEquals("Add method not working correctly.", "Error! Trying to add a child on a Leaf!\n", output.toString());
	}

}
