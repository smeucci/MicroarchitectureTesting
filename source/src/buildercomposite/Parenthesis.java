package buildercomposite;

/**
 * 
 */
public class Parenthesis extends Operator {

    private Component child;
    
    public Parenthesis() {
    	super("PARENTHESIS");
    	//System.out.println( getName() + " created.");
    }

    public void draw() {
        System.out.print("(");
        child.draw();
        System.out.print(")");
    }

    public Boolean evaluate() {
        return child.evaluate();
    }

    public void add(Component c) {
        this.child = c;
    }

}