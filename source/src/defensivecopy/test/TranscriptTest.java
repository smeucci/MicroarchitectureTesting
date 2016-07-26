package defensivecopy.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import defensivecopy.Exam;
import defensivecopy.Transcript;

public class TranscriptTest {

	private Transcript transcript;
	private String[] names = {"Test1", "Test2", "Test3"};
	private int[] scores = {30, 28, 27};
	private int[] cfus = {9, 6, 9};
	
	@Before
	public void setup() {
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			exams.add(new Exam(names[i], scores[i], cfus[i]));
		}
		
		transcript = new Transcript(exams);
		
	}
	
	
	/**
	 * Testing getExams method
	 * 
	 */
	@Test
	public void getExamsTest() {
		
		ArrayList<Exam> exams = transcript.getExams();
		int i = 0;
		for (Exam exam: exams) {
			
			assertEquals("Exam name not corresponding.", names[i], exam.getName());
			assertEquals("Exam score not corresponding.", scores[i], exam.getScore());
			assertEquals("Exam cfu not corresponding.", cfus[i], exam.getCFU());
			i++;
			
		}
		
	}
	
	
	/**
	 * Testing addExam method
	 * 
	 */
	@Test
	public void addExamTest() {
		
		Exam exam = new Exam("Test4", 29, 6);
		transcript.addExam(exam);
		
		ArrayList<Exam> exams = transcript.getExams();
		
		assertEquals("Number of exams not correct.", 4, exams.size());
		
		assertEquals("Exam name not corresponding.", "Test4", exams.get(exams.size() - 1).getName());
		assertEquals("Exam score not corresponding.", 29, exams.get(exams.size() - 1).getScore());
		assertEquals("Exam cfu not corresponding.", 6, exams.get(exams.size() - 1).getCFU());
		
	}
	
	
	/**
	 * Testing constructors
	 * 
	 */
	@Test
	public void ConstructorsTest() {
		
		Transcript transcript2 = new Transcript(transcript);
		
		ArrayList<Exam> exams1 = transcript.getExams();
		ArrayList<Exam> exams2 = transcript2.getExams();
		
		assertEquals("Size of array is not the same.", exams1.size(), exams2.size());
		
		for (int i = 0; i < exams1.size(); i++) {
			
			assertEquals("Exams names not corresponding.", exams1.get(i).getName(), exams2.get(i).getName());
			assertEquals("Exams scores not corresponding.", exams1.get(i).getScore(), exams2.get(i).getScore());
			assertEquals("Exams cfus not corresponding.", exams1.get(i).getCFU(), exams2.get(i).getCFU());
			
		}
		
	}

}
