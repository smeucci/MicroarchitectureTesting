package defensivecopy.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import defensivecopy.Exam;

public class ExamTest {

	private Exam exam;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setup() {
		exam = new Exam("Test", 30, 9);
	}
	
	@Before
	public void setuptStream() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void clearStream() {
		System.setOut(null);
	}
	
	
	/**
	 * Testing getName method
	 * 
	 */
	@Test
	public void getNameTest() {
		assertEquals("Exam name not correct.", "Test", exam.getName());
	}
	
	
	/**
	 * Testing getScore method
	 * 
	 */
	@Test
	public void getScoreTest() {
		assertEquals("Exam score not correct.", 30, exam.getScore());
	}
	
	
	/**
	 * Testing getCFU method
	 * 
	 */
	@Test
	public void getCFUTest() {
		assertEquals("Exam cfu not correct.", 9, exam.getCFU());
	}
	
	
	/**
	 * Testing constructors
	 * 
	 */
	@Test
	public void ConstructorsTest() {
		
		Exam exam1 = new Exam("Test", 30, 9);
		Exam exam2 = new Exam(exam1);
		
		assertEquals("Exams names are not the same.", exam1.getName(), exam2.getName());
		assertEquals("Exams scores are not the same.", exam1.getScore(), exam2.getScore());
		assertEquals("Exams cfu are not the same.", exam1.getCFU(), exam2.getCFU());
		
	}
	
	
	/**
	 * Testing toString method
	 * 
	 */
	@Test
	public void toStringTest() {
		
		assertEquals("toStrig method not working properly.", "Test, score: 30, cfu: 9", exam.toString());
		
	}

}
