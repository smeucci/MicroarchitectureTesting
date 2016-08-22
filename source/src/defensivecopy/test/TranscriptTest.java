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
		
		Exam e;
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			e = new Exam(names[i], cfus[i]);
			e.setScore(scores[i]);
			exams.add(e);
		}
		
		transcript = new Transcript(exams);
		
	}
	
	
	/**
	 * Testing getExams method. The array of exams must be returned.
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
	 * Testing addExam method. A new exam must be added to the transcript with the correct attributes.
	 * 
	 */
	@Test
	public void addExamTest() {
		
		Exam exam = new Exam("Test4", 6);
		exam.setScore(29);
		transcript.addExam(exam);
		
		ArrayList<Exam> exams = transcript.getExams();
		
		assertEquals("Number of exams not correct.", 4, exams.size());
		
		assertEquals("Exam name not corresponding.", "Test4", exams.get(exams.size() - 1).getName());
		assertEquals("Exam score not corresponding.", 29, exams.get(exams.size() - 1).getScore());
		assertEquals("Exam cfu not corresponding.", 6, exams.get(exams.size() - 1).getCFU());
		
	}
	
	
	/**
	 * Testing constructors. Check if the two ways of calling the constructor return the same object as a result.
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
	
	
	/**
	 * Testing modifyExam method. The exam attributes must change accordingly to the arguments passed.
	 * 
	 */
	@Test
	public void modifyExamTest() {
		
		assertEquals("Exam name not correct.", "Test1", transcript.getExams().get(0).getName());
		assertEquals("Exam score not correct.", 30, transcript.getExams().get(0).getScore());
		assertEquals("Exam cfu not correct.", 9, transcript.getExams().get(0).getCFU());
		
		transcript.getExams().get(0).setName("Test1Changed");
		transcript.getExams().get(0).setScore(29);
		transcript.getExams().get(0).setCFU(6);
		
		assertEquals("Exam name not correctly changed.", "Test1Changed", transcript.getExams().get(0).getName());
		assertEquals("Exam score not correctly changed.", 29, transcript.getExams().get(0).getScore());
		assertEquals("Exam cfu not correctly changed.", 6, transcript.getExams().get(0).getCFU());

	}
	
	
	/**
	 * Testing removeExam method. The exam that has the name attribute the same as the argument passed, must be remove from the transcript.
	 * The size of the array of exams must decrease by one.
	 */
	@Test
	public void removeExamTest() {
		
		assertEquals("Size of the exams array not correct.", 3, transcript.getExams().size());
		
		transcript.removeExam("Test1");
		assertEquals("Size of the exams array not correctly updated.", 2, transcript.getExams().size());

	}
	
	
	/**
	 * Testing removeAllExams method. The transcript must be cleared of all the exams. The size of the array of exams must be 0.
	 * 
	 */
	@Test
	public void removeAllExamsTest() {
		
		assertEquals("Size of the exams array not correct.", 3, transcript.getExams().size());
		
		transcript.removeAllExams();;
		assertEquals("Size of the exams array not correctly updated.", 0, transcript.getExams().size());
		
	}
	
	
	/**
	 * Testing getExam method. Return the object exam of the transcript corresponding to the string name passed. If the exam with that name
	 * is not present, return null.
	 */
	@Test
	public void getExamTest() {
		
		assertEquals("Exam name not corresponding.", "Test1", transcript.getExam("Test1").getName());
		assertEquals("Exam score not corresponding.", 30, transcript.getExam("Test1").getScore());
		assertEquals("Exam cfu not corresponding.", 9, transcript.getExam("Test1").getCFU());
		
		assertEquals("Expected null.", null, transcript.getExam("Test5"));
		
	}
	
}
