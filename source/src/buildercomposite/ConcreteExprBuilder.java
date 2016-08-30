package buildercomposite;

/**
 * 
 */
public class ConcreteExprBuilder extends ExprBuilder {

    public ConcreteExprBuilder() {
    	//System.out.println("A new builder has been created.");
    }

    public Component BuildVariable(String s, Boolean b) {
        Component v = new Variable(s);
        v.setValue(b);
        return v;
    }

    public Component BuildAnd(Component a, Component b) {
        Component and = new And();
        try {
			and.add(a);
	        and.add(b);
		} catch (InvalidComponentAddingException e) {
			e.getMessage();
		}
        return and;
    }

    public Component BuildOr(Component a, Component b) {
    	Component or = new Or();
        try {
			or.add(a);
			or.add(b);
		} catch (InvalidComponentAddingException e) {
			e.getMessage();
		}
       
        return or;
    }
    
    public Component BuildNot(Component c) {
    	Component not = new Not();
    	try {
			not.add(c);
		} catch (InvalidComponentAddingException e) {
			e.getMessage();
		}
    	return not;
    }

    public Component BuildParenthesis(Component c) {
    	Component par = new Parenthesis();
    	try {
			par.add(c);
		} catch (InvalidComponentAddingException e) {
			e.getMessage();
		}
    	return par;
    }

}