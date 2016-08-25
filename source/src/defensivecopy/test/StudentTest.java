package defensivecopy.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import defensivecopy.DegreeCourse;
import defensivecopy.Exam;
import defensivecopy.Student;
import defensivecopy.Transcript;
import defensivecopy.Professor;

public class StudentTest {

	private Student student;
	private Transcript transcript;
	private String[] names = {"Test1", "Test2", "Test3", "Test4"};
	private int[] scores = {30, 28, 27, -1};
	private int[] cfus = {9, 6, 9, 6};
	
	@Mock
	private Professor mockProfessor;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
		Exam e;
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 4; i++) {
			e = new Exam(names[i], cfus[i]);
			e.setScore(scores[i]);
			exams.add(e);
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
	
	}
	
	
	/**
	 * Testing getExams method. Return all the exams in the transcript associated to the student. Check if the attributes of the exams are correct
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
	 * Testing addExam method. A new exam must be added to the array. The size of array must increase by one for each exam added.
	 * 
	 */
	@Test
	public void addExamTest() {
		
		Exam exam = new Exam("Test5", 6);
		
		exam.setProfessor(mockProfessor);
        when(exam.getProfessor().giveScore()).thenReturn(29);
		exam.giveScore();
		
		student.addExam(exam);
		
		ArrayList<Exam> exams = student.getExams();
		
		assertEquals("Number of exams not correct.", 5, exams.size());
		
		assertEquals("Exam name not corresponding.", "Test5", exams.get(exams.size() - 1).getName());
		assertEquals("Exam score not corresponding.", 29, exams.get(exams.size() - 1).getScore());
		assertEquals("Exam cfu not corresponding.", 6, exams.get(exams.size() - 1).getCFU());
		
	}
	
	
	/**
	 * Testing getTrascript method. Return the transcript of the student. The size of the array of the returned transcript and the transcript
	 * attribute of the student must be the same. They also should contain the same exams.
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
	 * Test getAverage method. Compute the average score and check if it is equal to a predetermined value.
	 * 
	 */
	@Test
	public void getAverageTest() {
		
		float average = (float) 28.375;
		assertEquals("Average score not correct.", (double) average, (double) student.getAverage(new DegreeCourse("CourseTest", "DegreeTest")), (double) 0.001);

	}
	
	
	/**
	 * Testing removeExam method. The exam that has the name attribute the same as the argument passed, must be remove from the transcript
	 * of the student. The size of the array of exams must decrease by one.
	 */
	@Test
	public void removeExamTest() {
		
		assertEquals("Size of the exams array not correct.", 4, student.getExams().size());
		
		student.removeExam("Test1");
		assertEquals("Size of the exams array not correctly updated.", 3, student.getExams().size());

	}
	
	
	/**
	 * Testing removeAllExams method. The transcript of the student must be cleared of all the exams. The size of the array of exams must be 0.
	 * 
	 */
	@Test
	public void removeAllExamsTest() {
		
		assertEquals("Size of the exams array not correct.", 4, student.getExams().size());
		
		student.removeAllExams();;
		assertEquals("Size of the exams array not correctly updated.", 0, student.getExams().size());
		
	}
	
	
	/**
	 * Testing getExam method. Return the object exam of the transcript of the student corresponding to the string name passed and change its score.
	 * If an exam with that name does not exist, return null.
	 */
	@Test
	public void getExamTest() {
		
		Exam exam = student.getExam("Test4");
		
		assertEquals("Exam name not corresponding.", "Test4", exam.getName());
		assertEquals("Exam score not corresponding.", -1, exam.getScore());
		assertEquals("Exam cfu not corresponding.", 6, exam.getCFU());
		
		exam.setProfessor(mockProfessor);
        when(exam.getProfessor().giveScore()).thenReturn(25);
		exam.giveScore();
		assertEquals("Exam score not corresponding.", 25, exam.getScore());
		
		assertEquals("Expected null.", null, student.getExam("Test5"));
		
	}
		
}

