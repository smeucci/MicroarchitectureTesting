package buildercomposite;

/**
 * 
 */
public class Composite extends Component {

	private String name;
    private Boolean value;
	
    public Composite(String s) {
    	this.name = s;
    }

    public void draw() {}
    public Boolean evaluate() {return true;}

    public void add(Component c) {
    	System.out.println("Error! Trying to add a child on a Leaf!");
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

}