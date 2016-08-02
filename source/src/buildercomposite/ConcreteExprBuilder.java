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
        and.add(a);
        and.add(b);
        return and;
    }

    public Component BuildOr(Component a, Component b) {
    	Component or = new Or();
        or.add(a);
        or.add(b);
        return or;
    }
    
    public Component BuildNot(Component c) {
    	Component not = new Not();
    	not.add(c);
    	return not;
    }

    public Component BuildParenthesis(Component c) {
    	Component par = new Parenthesis();
    	par.add(c);
    	return par;
    }

}