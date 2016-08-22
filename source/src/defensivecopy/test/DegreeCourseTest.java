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
	 * Testing getName method. Check if the returned name is the one expected.
	 * 
	 */
	@Test
	public void getNameTest() {
		assertEquals("Course name not corresponding.", "CourseTest", course.getName());
	}
	
	
	/**
	 * Testing setName method. Check if the attribute name is correctly changed accordingly to the argument passed.
	 * 
	 */
	@Test
	public void setNameTest() {
		assertEquals("Course name not corresponding.", "CourseTest", course.getName());
		course.setName("Changed");
		assertEquals("Course name not correctly changed.", "Changed", course.getName());
	}
	
	
	/**
	 * Testing getDegree method. Check if the degree attribute is the one expected.
	 * 
	 */
	@Test
	public void getDegreeTest() {
		assertEquals("Course degree not corresponding.", "DegreeTest", course.getDegree());
	}
	
	
	/**
	 * Testing setDegree method. Check if the attribute degree is correctly changed accordingly to the argument passed.
	 * 
	 */
	@Test
	public void setDegreeTest() {
		assertEquals("Course degree not corresponding.", "DegreeTest", course.getDegree());
		course.setDegree("Changed");
		assertEquals("Course degree not correctly changed.", "Changed", course.getDegree());
	}
	
	
	/**
	 * Testing getAverage method. Compute the average of all the exam contains in the passed transcript. Check if is equal to a predetermined
	 * value. Also check if getAverage method of DegreeCourse and of Student returned the same value.
	 */
	@Test
	public void getAverageTest() {
		
		float average = (float) 28.375;
		
		Exam e;
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			e = new Exam(names[i], cfus[i]);
			e.setScore(scores[i]);
			exams.add(e);
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
		
		assertEquals("Average score not corresponding.", (double) student.getAverage(course), (double) course.getAverage(transcript), (double) 0.001);
		assertEquals("Average score not correct.", (double) average, (double) course.getAverage(transcript), (double) 0.001);
		
	}
	
}
