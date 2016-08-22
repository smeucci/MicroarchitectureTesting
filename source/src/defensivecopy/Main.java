package defensivecopy;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		DegreeCourse course = new DegreeCourse("Ingegneria Informatica", "Magistrale");
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		Exam e = new Exam("Metodi di Ottimizzazione", 6);
		exams.add(e);
		
		Transcript transcript = new Transcript(exams);
		Student student = new Student(new Transcript(transcript));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
		student.addExam(new Exam("Informatica Teorica", 6));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
		e = student.getExam("Informatica Teorica");
		e.setScore(30);
		e = student.getExam("Metodi di Ottimizzazione");
		e.setScore(28);
		
		//student.removeExam("Informatica Teorica");
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
	}
	
}
