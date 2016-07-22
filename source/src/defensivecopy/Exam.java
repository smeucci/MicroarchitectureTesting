package defensivecopy;

/**
 * 
 */
public final class Exam {

	private final String name;
	private final int score;
	private final int cfu;
	
    public Exam(String name, int score, int cfu) {
    	this.name = name;
    	this.score = score;
    	this.cfu = cfu;
    }
    
    public Exam(Exam e) {
        this.name = e.getName();
        this.score = e.getScore();
        this.cfu = e.getCFU();
    }

    
    public String getName() {
    	return this.name;
    }
    
    public int getScore() {
        return this.score;
    }

    public int getCFU() {
        return this.cfu;
    }
    
    public String toString() {
    	return this.name + ", score: " + this.score + ", cfu: " + this.cfu;
    }

}