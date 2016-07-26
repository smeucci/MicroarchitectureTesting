package defensivecopy.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import defensivecopy.DegreeCourse;
import defensivecopy.Exam;
import defensivecopy.Student;
import defensivecopy.Transcript;

public class StudentTest {

	private Student student;
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
		student = new Student(transcript);
	
	}
	
	
	/**
	 * Testing getExams method
	 * 
	 */
	@Test
	public void getExamsTest() {
		
		ArrayList<Exam> exams = student.getExams();
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
		student.addExam(exam);
		
		ArrayList<Exam> exams = student.getExams();
		
		assertEquals("Number of exams not correct.", 4, exams.size());
		
		assertEquals("Exam name not corresponding.", "Test4", exams.get(exams.size() - 1).getName());
		assertEquals("Exam score not corresponding.", 29, exams.get(exams.size() - 1).getScore());
		assertEquals("Exam cfu not corresponding.", 6, exams.get(exams.size() - 1).getCFU());
		
	}
	
	
	/**
	 * Testing getTrascript method
	 * 
	 */
	@Test
	public void getTranscriptTest() {
				
		assertEquals("Size of array is not the same.", transcript.getExams().size(), student.getTranscript().getExams().size());
		
		for (int i = 0; i < transcript.getExams().size(); i++) {
			
			assertEquals("Exams names not corresponding.", transcript.getExams().get(i).getName(), student.getTranscript().getExams().get(i).getName());
			assertEquals("Exams scores not corresponding.", transcript.getExams().get(i).getScore(), student.getTranscript().getExams().get(i).getScore());
			assertEquals("Exams cfus not corresponding.", transcript.getExams().get(i).getCFU(), student.getTranscript().getExams().get(i).getCFU());
			
		}
		
	}
	
	
	/**
	 * Test getAverage method
	 * 
	 */
	@Test
	public void getAverageTest() {
		
		float average = (float) 28.375;
		assertEquals("Average score not correct.", (double) average, (double) student.getAverage(new DegreeCourse("CourseTest", "DegreeTest")), (double) 0.001);

	}
	
}
