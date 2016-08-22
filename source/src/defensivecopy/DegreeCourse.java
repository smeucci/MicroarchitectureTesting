package defensivecopy;


/**
 * 
 */
public class DegreeCourse {
	
	private String name;
	private String degree;
	
    public DegreeCourse(String name, String degree) {
    	this.name = name;
    	this.degree = degree;
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

    public float getAverage(Transcript t) {
        float sum = 0;
        float cfu = 0;
        for (Exam e: t.getExams()) {
        	if (e.getScore() != -1) {
	        	sum += e.getCFU() * e.getScore();
	        	cfu += e.getCFU();
        	}
        }
        
        return sum / cfu;
    }

}