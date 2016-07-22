package defensivecopy;
import java.util.*;

/**
 * 
 */
public class Student {

	private final Transcript transcript;
	
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

    public ArrayList<Exam> getExams() {
        return this.transcript.getExams();
    }

}