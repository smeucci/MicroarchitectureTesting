package buildercomposite;

/**
 * 
 */
public class Variable extends Component {

	private String name;
	private Boolean value;
	
    public Variable(String s) {
    	this.name = s;
    	this.value = null;
    }
    
    public String getName() {
    	return this.name;
    }

    public Boolean getValue() {
    	return this.value;
    }
    
    public void setValue(Boolean b) {
    	this.value = b;
    }
    
    public void draw() {
        System.out.print( getName() + ":" + getValue() );
    }

    public Boolean evaluate() {
        return getValue();
    }
    
    public void add(Component c) {
    	System.out.println("Error! Trying to add a child on a Leaf!");
    }

}