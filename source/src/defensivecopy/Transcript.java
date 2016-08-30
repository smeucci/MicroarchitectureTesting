package defensivecopy;
import java.util.*;

/**
 * 
 */
public class Transcript {

	private ArrayList<Exam> exams;
	
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
    		this.exams.add(new Exam(e));
    	}
    }

    public void addExam(Exam e) {
        this.exams.add(new Exam(e));
    }
    
    public void removeExam(String name) {
    	for (Iterator<Exam> it = this.exams.iterator(); it.hasNext();) {
    		Exam e = it.next();
    		if (e.getName().equals(name)) {
    			it.remove();
    		}
    	}
    }
    
    public void removeAllExams() {
    	this.exams.clear();;
    	
    }
    
    public Exam getExam(String name) {
    	for (Exam e: this.exams) {
    		if (e.getName().equals(name)) {
    			return e;
    		}
    	}
    	
    	return null;
    }

    public ArrayList<Exam> getExams() {
        return this.exams;
    }

}