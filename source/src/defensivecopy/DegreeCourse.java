package defensivecopy;

/**
 * 
 */
public class DegreeCourse {

	private final String name;
	private final String degree;
	
    public DegreeCourse(String name, String degree) {
    	this.name = name;
    	this.degree = degree;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getDegree() {
    	return this.degree;
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