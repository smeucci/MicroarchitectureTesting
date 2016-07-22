package defensivecopy;
import java.util.*;

/**
 * 
 */
public class Transcript {

	private final ArrayList<Exam> exams;
	
    public Transcript() {
    	this.exams = new ArrayList<Exam>();
    }

    public Transcript(Transcript t) {
        this.exams = new ArrayList<Exam>();
        for (Exam e: t.getExams()) {
        	this.exams.add(new Exam(e));
        }
    }
    
    public Transcript(ArrayList<Exam> exams) {
    	this.exams = new ArrayList<Exam>();
    	for (Exam e: exams) {
    		this.exams.add(new Exam(e.getName(), e.getScore(), e.getCFU()));
    	}
    }

    public void addExam(Exam e) {
        this.exams.add(new Exam(e));
    }

    public ArrayList<Exam> getExams() {
        return this.exams;
    }

}