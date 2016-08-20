package defensivecopy.testold;

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
	 * Testing getName method. Must return the correct name attribute of the exam.
	 * 
	 */
	@Test
	public void getNameTest() {
		assertEquals("Exam name not correct.", "Test", exam.getName());
	}
	
	
	/**
	 * Testing getScore method. Must return the correct score attribute of the exam.
	 * 
	 */
	@Test
	public void getScoreTest() {
		assertEquals("Exam score not correct.", 30, exam.getScore());
	}
	
	
	/**
	 * Testing getCFU method. Must return the correct cfu attribute of the exam.
	 * 
	 */
	@Test
	public void getCFUTest() {
		assertEquals("Exam cfu not correct.", 9, exam.getCFU());
	}
	
	
	/**
	 * Testing constructors. Compare if calling the constructor in two different ways return the same exam as a result.
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
	 * Testing toString method. Check if the output of the exam works correctly.
	 * 
	 */
	@Test
	public void toStringTest() {
		
		assertEquals("toStrig method not working properly.", "Test, score: 30, cfu: 9", exam.toString());
		
	}
	
	
	/**
	 * Testing setName method. The name attribute must change accordingly to the argument passed.
	 */
	@Test
	public void setNameTest() {
		
		assertEquals("Exam name not correct.", "Test", exam.getName());
		exam.setName("Changed");
		assertEquals("Exam name not correctly changed.", "Changed", exam.getName());
		
	}
	
	
	/**
	 * Testing setScore method. The score attribute must change accordingly to the argument passed.
	 */
	@Test
	public void setScoreTest() {
		
		assertEquals("Exam score not correct.", 30, exam.getScore());
		exam.setScore(29);
		assertEquals("Exam score not correctly changed.", 29, exam.getScore());
		
	}
	
	
	/**
	 * Testing setCFU method. The name attribute must change accordingly to the argument passed.
	 */
	@Test
	public void setCFUTest() {
		
		assertEquals("Exam cfu not correct.", 9, exam.getCFU());
		exam.setCFU(6);
		assertEquals("Exam cfu not correctly changed.", 6, exam.getCFU());
		
	}
	
}
