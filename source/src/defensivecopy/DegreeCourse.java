package defensivecopy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */
public class DegreeCourse {
	
	private String name;
	private String degree;
	private ArrayList<Student> students;
	
    public DegreeCourse(String name, String degree) {
    	this.name = name;
    	this.degree = degree;
    	this.students = new ArrayList<Student>();
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getDegree() {
    	return this.degree;
    }
    
    public void setDegree(String degree) {
    	this.degree = degree;
    }
    
    public void registerStudent(Student student) {
    	this.students.add(student);
    }
    
    public void unregisterStudent(Student student) {
    	for (Iterator<Student> it = this.students.iterator(); it.hasNext();) {
    		Student s = it.next();
    		if (s.equals(student)) {
    			it.remove();
    		}
    	}
    }
    
    public ArrayList<Student> getStudents() {
    	return this.students;
    }

    public float getAverage(Transcript t) {
        float sum = 0;
        float cfu = 0;
        for (Exam e: t.getExams()) {
        	sum += e.getCFU() * e.getScore();
        	cfu += e.getCFU();
        }
        
        return sum / cfu;
    }

}