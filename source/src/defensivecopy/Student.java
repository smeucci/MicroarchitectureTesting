package defensivecopy;
import java.util.*;

/**
 * 
 */
public class Student {

	private Transcript transcript;
	
    public Student(Transcript transcript) {
    	this.transcript = new Transcript(transcript);
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

}