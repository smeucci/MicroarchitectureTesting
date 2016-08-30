package buildercomposite;

/**
 * 
 */
public abstract class Component {
	
	public abstract void draw();
    public abstract Boolean evaluate();
    public abstract String getName();
    public abstract Boolean getValue();
    public abstract void setValue(Boolean b);
    public void add(Component c) throws InvalidComponentAddingException{
    	throw new InvalidComponentAddingException("Cannot add a component to a leaf.");
    };

}
