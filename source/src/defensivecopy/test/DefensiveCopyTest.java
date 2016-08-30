package defensivecopy.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import defensivecopy.*;

public class DefensiveCopyTest {

	@Mock Professor mockProfessor;
	
	public final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
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
	 * Number: 1
	 * Title: Exam creation
	 * Description: An exam is created with the desired name, the desired CFU and a default score of -1.
	 * 
	 */
	@Test
	public void ExamCreationTest() {
		
		Exam exam = new Exam("Test Exam", 9);
		
		assertEquals("Exam name not correctly assigned.", "Test Exam", exam.getName());
		assertEquals("Exam cfu not correctly assigned.", 9, exam.getCFU());
		assertEquals("Exam score not correctly initialised.", -1, exam.getScore());
		
	}
	
	
	/*
	 * Number: 2
	 * Title: Exam insertion in transcript
	 * Description: An exam is correctly inserted in a Trascript. The insertion is made using a defensive copy
	 * wrt the Exam object. The size of the transcript should increase by 1.
	 * 
	 */
	@Test
	public void ExamInsertionTranscriptTest() {
			
		// ################
		// ##   Case 1   ##
		// ################
		Transcript transcript = new Transcript();
		assertEquals("The size of the transcript should be 0.", 0, transcript.getExams().size());
		
		Exam exam = new Exam("Test Exam", 9);
		exam.setProfessor(mockProfessor);
		transcript.addExam(exam);
		assertEquals("The size of the transcript should be 1.", 1, transcript.getExams().size());
		
		// Check that the copy succeeded
		assertEquals("Exams names shouble be the same.", exam.getName(), transcript.getExam("Test Exam").getName());
		assertEquals("Exams cfus shouble be the same.", exam.getCFU(), transcript.getExam("Test Exam").getCFU());
		assertEquals("Exams scores shouble be the same.", exam.getScore(), transcript.getExam("Test Exam").getScore());
		assertEquals("Exams professor shouble be the same.", exam.getProfessor(), transcript.getExam("Test Exam").getProfessor());
		
		// Check that changes to the copy do not affect the original
		transcript.getExam("Test Exam").setCFU(6);
		assertNotEquals("Exams cfus should be different.", exam.getCFU(), transcript.getExam("Test Exam").getCFU());
		
		// ################
		// ##   Case 2   ##
		// ################
		ArrayList<Exam> exams = new ArrayList<Exam>();
		exams.add(exam);
		
		transcript = new Transcript(exams);
		assertEquals("The size of the transcript should be 1.", 1, transcript.getExams().size());
		
		// Check that the copy succeeded
		assertEquals("Exams names shouble be the same.", exam.getName(), transcript.getExam("Test Exam").getName());
		assertEquals("Exams cfus shouble be the same.", exam.getCFU(), transcript.getExam("Test Exam").getCFU());
		assertEquals("Exams scores shouble be the same.", exam.getScore(), transcript.getExam("Test Exam").getScore());
		assertEquals("Exams professor shouble be the same.", exam.getProfessor(), transcript.getExam("Test Exam").getProfessor());
		
		// Check that changes to the copy do not affect the original
		transcript.getExam("Test Exam").setCFU(6);
		assertNotEquals("Exams cfus should be different.", exam.getCFU(), transcript.getExam("Test Exam").getCFU());
		
		// ################
		// ##   Case 3   ##
		// ################
		transcript = new Transcript(exams);
		Transcript transcript2 = new Transcript(transcript);
		assertEquals("The size of the transcript should be 1.", 1, transcript2.getExams().size());
		
		// Check that the copy succeeded
		assertEquals("Exams names shouble be the same.", exam.getName(), transcript2.getExam("Test Exam").getName());
		assertEquals("Exams cfus shouble be the same.", exam.getCFU(), transcript2.getExam("Test Exam").getCFU());
		assertEquals("Exams scores shouble be the same.", exam.getScore(), transcript2.getExam("Test Exam").getScore());
		assertEquals("Exams professor shouble be the same.", exam.getProfessor(), transcript.getExam("Test Exam").getProfessor());
		
		// Check that changes to the copy do not affect the original
		transcript2.getExam("Test Exam").setCFU(6);
		assertNotEquals("Exams cfus should be different.", exam.getCFU(), transcript2.getExam("Test Exam").getCFU());
		
	}
	
	
	/*
	 * Number: 3
	 * Title: Student-Transcript association.
	 * Description: A transcript can be associated to a Student. The association is made using a defensive copy wrt to the transcript.
	 * 
	 */
	@Test
	public void StudentTranscriptAssociationTest() {
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		exams.add(new Exam("Test 1", 6));
		exams.add(new Exam("Test 2", 6));
		
		Transcript transcript = new Transcript(exams);
		
		Student student = new Student(transcript);
		
		// Check that the copy and the original transcript have the same size.
		assertEquals("The size of the two transcripts should be equal.", transcript.getExams().size(), student.getExams().size());
		
		// Check that changes to the copy transcript do not affect the original transcript.
		student.addExam(new Exam("Test 3", 9));
		assertNotEquals("The size of the two transcripts should be different.", transcript.getExams().size(), student.getExams().size());
		
	}
	
	
	/*
	 * Number: 4
	 * Title: Good Score assignment by Professor
	 * Description: A Professor should be associated to an exam. When a Professor set an exam score that is in the prefixed
	 * range (from 18 to 30), the exam score must change accordingly. Professor is a mocked class.
	 * 
	 */
	 @Test
	 public void GoodScoreAssignmentProfessorTest() throws OutOfRangeScoreException {
		 
		 Student student = new Student(new Transcript());
		 Exam exam = new Exam("Test 1", 6);
		 exam.setProfessor(mockProfessor);
		 
		 student.addExam(exam);
		 
		 assertEquals("Exam score not initialised correctly.", -1, student.getExam("Test 1").getScore());
		 
		 when(mockProfessor.giveScore()).thenReturn(30);
		 student.getExam("Test 1").giveScore();
		 assertEquals("Exam score not assigned correctly by Professor.", 30, student.getExam("Test 1").getScore());
		 
	 }
	 
	 
	 /*
	 * Number: 5
	 * Title: Bad Score assignment by Professor
	 * Description: A Professor should be associated to an exam. When a Professor set an exam score out of the prefixed
	 * range (from 18 to 30) an exception should be thrown. Professor is a mocked class.
	 * 
	 */
	 @Test(expected=OutOfRangeScoreException.class)
	 public void BadScoreAssignmentProfessorTest() throws OutOfRangeScoreException {
		 
		 Student student = new Student(new Transcript());
		 Exam exam = new Exam("Test 1", 6);
		 exam.setProfessor(mockProfessor);
		 
		 student.addExam(exam);
		 
		 assertEquals("Exam score not initialised correctly.", -1, student.getExam("Test 1").getScore());
		 
		 when(mockProfessor.giveScore()).thenReturn(50);
		 student.getExam("Test 1").giveScore();
		 
	 }
	 
	 
	 /*
	  * Number: 6
	  * Title: Average score evaluation.
	  * Description: When the score average is requested by the student, a copy of the transcript is passed to a DegreeCourse for the
	  * evaluation, implementing a defensive copy. All the exams with a score different from -1 must be considered
	  */
	@Test
	public void AverageScoreEvaluationTest() {
		
		float expectedAverageScore = (float) 27;
		
		DegreeCourse course = new DegreeCourse("Computer Engineering", "Master");
		
		Exam exam1 = new Exam("Test 1", 6);
		Exam exam2 = new Exam("Test 2", 6);
		Exam exam3 = new Exam("Test 3", 9);
		
		exam1.setScore(30);
		exam3.setScore(25);
		
		Transcript transcript = new Transcript();
		Student student = new Student(transcript);
		student.addExam(exam1);
		student.addExam(exam2);
		student.addExam(exam3);
		
		assertEquals("Average score not correct.", (double) expectedAverageScore, (double) student.getAverage(course), (double) 0.001);
		
	}
	
	
	/*
	 * Number: 7
	 * Title: Exam removal.
	 * Description: An exam can be removed from a transcript. Therefore it shoudl not be considered in the average score evaluation.
	 * 
	 */
	@Test
	public void ExamRemovalTest() {
		
		float expectedAverageScore = (float) 27.285;
		
		DegreeCourse course = new DegreeCourse("Computer Engineering", "Master");
		
		Exam exam1 = new Exam("Test 1", 6);
		Exam exam2 = new Exam("Test 2", 6);
		Exam exam3 = new Exam("Test 3", 9);
		
		exam1.setScore(30);
		exam2.setScore(28);
		exam3.setScore(25);
		
		Transcript transcript = new Transcript();
		Student student = new Student(transcript);
		student.addExam(exam1);
		student.addExam(exam2);
		student.addExam(exam3);
		
		assertEquals("Size of the transcript not correct.", 3, student.getExams().size());
		assertEquals("Average score not correct.", (double) expectedAverageScore, (double) student.getAverage(course), (double) 0.001);
		
		// Remove an exam.
		
		student.removeExam("Test 2");
		assertEquals("Size of the transcript not correct.", 2, student.getExams().size());
		assertEquals("The exam removed should not be in the transcript.", null, student.getExam("Test 2"));
		
		float newExpectedAverageScore = (float) 27;
		assertEquals("Average score not correct.", (double) newExpectedAverageScore, (double) student.getAverage(course), (double) 0.001);
		
	}
	
	
	/*
	 * Number: 8
	 * Title: Clear Transcript.
	 * Description: All the included exams are removed from the transcript.
	 * 
	 */
	@Test
	public void ClearTranscriptTest() {
		
		Exam exam1 = new Exam("Test 1", 6);
		Exam exam2 = new Exam("Test 2", 6);
		Exam exam3 = new Exam("Test 3", 9);
		
		Transcript transcript = new Transcript();
		Student student = new Student(transcript);
		student.addExam(exam1);
		student.addExam(exam2);
		student.addExam(exam3);
		
		assertEquals("Size of the transcript not correct.", 3, student.getExams().size());

		student.removeAllExams();
		assertEquals("Size of the transcript not correct.", 0, student.getExams().size());

	}


}
