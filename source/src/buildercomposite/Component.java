package buildercomposite;

/**
 * 
 */
public abstract class Component {
	
	public abstract void draw();
    public abstract Boolean evaluate();
    public abstract void add(Component c);
    public abstract String getName();
    public abstract Boolean getValue();
    public abstract void setValue(Boolean b);

}