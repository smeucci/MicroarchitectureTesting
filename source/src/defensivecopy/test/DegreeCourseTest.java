package defensivecopy.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import defensivecopy.DegreeCourse;
import defensivecopy.Exam;
import defensivecopy.Student;
import defensivecopy.Transcript;

public class DegreeCourseTest {

	private DegreeCourse course;
	private Transcript transcript;
	private Student student;
	private String[] names = {"Test1", "Test2", "Test3"};
	private int[] scores = {30, 28, 27};
	private int[] cfus = {9, 6, 9};
	
	@Before
	public void setup() {
		course = new DegreeCourse("CourseTest", "DegreeTest");
	}
	
	
	/**
	 * Testing getName method
	 * 
	 */
	@Test
	public void getNameTest() {
		assertEquals("Course name not corresponding.", "CourseTest", course.getName());
	}
	
	
	/**
	 * Testing getDegree method
	 * 
	 */
	@Test
	public void getDegreeTest() {
		assertEquals("Course degree not corresponding.", "DegreeTest", course.getDegree());
	}
	
	
	/**
	 * Testing getAverage method
	 * 
	 */
	@Test
	public void getAverageTest() {
		
		float average = (float) 28.375;
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			exams.add(new Exam(names[i], scores[i], cfus[i]));
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
		
		assertEquals("Average score not corresponding.", (double) student.getAverage(course), (double) course.getAverage(transcript), (double) 0.001);
		assertEquals("Average score not correct.", (double) average, (double) course.getAverage(transcript), (double) 0.001);
		
	}

}
