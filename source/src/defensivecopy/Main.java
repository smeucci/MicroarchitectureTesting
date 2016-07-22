package defensivecopy;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		DegreeCourse course = new DegreeCourse("Ingegneria Informatica", "Magistrale");
		
		ArrayList<Exam> exams = new ArrayList<Exam>();
		exams.add(new Exam("Metodi di Ottimizzazione", 29, 6));
		exams.add(new Exam("Sicurezza e Gestione delle Reti", 27, 6));
		exams.add(new Exam("Tecnologie delle Basi di Dati", 30, 9));
		exams.add(new Exam("Elaborazione e Protezione delle Immagini", 30, 6));
		exams.add(new Exam("Basi di Dati Multimediali", 30, 9));
		
		Transcript transcript = new Transcript(exams);
		Student student = new Student(new Transcript(transcript));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
		student.addExam(new Exam("Teoria dei Linguaggi di Programmazione", 27, 6));
		student.addExam(new Exam("Analisi Numerica", 30, 6));
		student.addExam(new Exam("Informatica Teorica", 25, 6));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
		student.getTranscript().addExam(new Exam("Analisi di Immagini e Video", 30, 9));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
		student.getTranscript().addExam(new Exam("Software Dependability", 30, 9));
		
		System.out.println(student.getExams().toString());
		System.out.println("Average: " + student.getAverage(course));
		
	}
	
}
