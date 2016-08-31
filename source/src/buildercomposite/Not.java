package buildercomposite;

public class Not extends Operator{
	
	private Component child;
	
	public Not() {
		super("NOT");
	}
	
	public void draw() {
		System.out.print(getName() + " ");
		//System.out.print("(");
		child.draw();
		//System.out.print(")");
	}
	
	public Boolean evaluate() {
		if (child.evaluate() == true) {
			setValue(false);
		} else {
			setValue(true);
		}
		return getValue();
	}
	
	public void add(Component c) {
		this.child = c;
	}

}
