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
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			exams.add(new Exam(names[i], scores[i], cfus[i]));
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
		
		assertEquals("Average score not corresponding.", (double) student.getAverage(course), (double) course.getAverage(transcript), (double) 0.001);
		assertEquals("Average score not correct.", (double) average, (double) course.getAverage(transcript), (double) 0.001);
		
	}
	
	
	/**
	 * Testing registerStudent method. Passing a student object, the student must be added to the array of students of the degree course.
	 * The size of the array must increase by one.
	 */
	@Test
	public void registerStudentTest() {
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			exams.add(new Exam(names[i], scores[i], cfus[i]));
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
		
		assertEquals("Size of the array of students not correct.", 0, course.getStudents().size());

		course.registerStudent(student);
		assertEquals("Student object not corresponding.", true, course.getStudents().contains(student));
		assertEquals("Size of the array of students not correct.", 1, course.getStudents().size());
		
	}
	
	
	/**
	 * Testing getStudents method. The size of the returned array must be as expected.
	 * 
	 */
	@Test
	public void getStudentsTest() {
		Transcript transcript = new Transcript();
		Student student = new Student(transcript);
		
		assertEquals("Size of the array of students not correct.", 0, course.getStudents().size());
		
		course.registerStudent(student);
		assertEquals("Size of the array of students not correct.", 1, course.getStudents().size());
		
	}
	
	
	/**
	 * Testing unregisterStudent method. The passed student must be remove from the array of student. The size of the array must decrease by one.
	 * 
	 */
	@Test
	public void unregisterStudentTest() {
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		for (int i = 0; i < 3; i++) {
			exams.add(new Exam(names[i], scores[i], cfus[i]));
		}
		
		transcript = new Transcript(exams);
		student = new Student(transcript);
		
		assertEquals("Size of the array of students not correct.", 0, course.getStudents().size());

		course.registerStudent(student);
		assertEquals("Student object not corresponding.", true, course.getStudents().contains(student));
		assertEquals("Size of the array of students not correct.", 1, course.getStudents().size());
		
		course.unregisterStudent(student);
		assertEquals("Student object not corresponding.", false, course.getStudents().contains(student));
		assertEquals("Size of the array of students not correct.", 0, course.getStudents().size());	
		
	}
	
}
