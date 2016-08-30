package defensivecopy;

/**
 * 
 */
public final class Exam {
	
	private String name;
	private int score;
	private int cfu;
	private Professor professor;
    
    public Exam(String name, int cfu) {
    	this.name = name;
    	this.score = -1;
    	this.cfu = cfu;
    }
    
    public Exam(Exam e) {
        this.name = e.getName();
        this.score = e.getScore();
        this.cfu = e.getCFU();
        this.professor = e.getProfessor();
    }

    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
    	this.score = score;
    }

    public int getCFU() {
        return this.cfu;
    }
    
    public void setCFU(int cfu) {
    	this.cfu = cfu;
    }
    
    public Professor getProfessor() {
    	return this.professor;
    }
    
    public void setProfessor(Professor professor) {
    	this.professor = professor;
    }
    
    public void giveScore() {
    	
    	int score = this.professor.giveScore();
    	if (score >= 18 && score <= 30) {
    		setScore(score);
    	} else {
    		System.out.println("Score out of range.");
    	}
    	
    }
    
    public String toString() {
    	return this.name + ", score: " + this.score + ", cfu: " + this.cfu;
    }

}