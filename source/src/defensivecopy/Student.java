package defensivecopy;
import java.util.*;

/**
 * 
 */
public class Student {

	private Transcript transcript;
	private DegreeCourse course;
	
    public Student(Transcript transcript) {
    	this.transcript = new Transcript(transcript);
    	this.course = null;
    }

    public float getAverage(DegreeCourse dg) {
        return dg.getAverage(new Transcript(this.transcript));
    }
    
    public Transcript getTranscript() {
    	return this.transcript;
    }

    public void addExam(Exam e) {
        this.transcript.addExam(e);
    }
    
    public void modifyExam(String name, int score, int cfu) {
    	this.transcript.modifyExam(name, score, cfu);
    }
    
    public void removeExam(String name) {
    	this.transcript.removeExam(name);
    }
    
    public void removeAllExams() {
    	this.transcript.removeAllExams();
    }

    public Exam getExam(String name) {
    	return this.transcript.getExam(name);
    }
    
    public ArrayList<Exam> getExams() {
        return this.transcript.getExams();
    }
    
    public DegreeCourse getDegreeCourse() {
    	return this.course;
    }
    
    public void subscribe(DegreeCourse course) {
    	this.course = course;
    	course.registerStudent(this);
    }
    
    public void unsubscribe(DegreeCourse course) {
    	this.course = null;
    	course.unregisterStudent(this);
    }

}