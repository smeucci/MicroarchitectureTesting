package buildercomposite;

/**
 * 
 */
public class Operator extends Component {

	private String name;
    private Boolean value;
	
    public Operator(String s) {
    	this.name = s;
    }

    public void draw() {}
    public Boolean evaluate() {return true;}

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