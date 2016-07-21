package buildercomposite;

/**
 * 
 */
public class And extends Composite {

	private Component[] children = new Component[2];
	
    public And() {
    	super(" AND ");
    	//System.out.println("Logical connective " + getName() + " created.");
    }

    public void draw() {
        children[0].draw();
        System.out.print( getName() );
        children[1].draw();
    }

    public Boolean evaluate() {
        if (children[0].evaluate() == true) {
        	if (children[1].evaluate() == true) {
        		setValue(true);
        		return getValue();
        	}
        }
        
        setValue(false);
        return getValue();
    }

    public void add(Component c) {
    	if (children[0] != null) {
    		children[1] = c;
    	} else {
    		children[0] = c;
    	}
    }

}