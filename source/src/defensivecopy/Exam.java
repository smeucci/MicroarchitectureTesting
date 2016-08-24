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
    
    public String toString() {
    	return this.name + ", score: " + this.score + ", cfu: " + this.cfu;
    }

}