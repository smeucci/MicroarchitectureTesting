package buildercomposite;

/**
 * 
 */
public abstract class ExprBuilder {

    public abstract Component BuildVariable(String s, Boolean b);

    public abstract Component BuildAnd(Component a, Component b);

    public abstract Component BuildOr(Component a, Component b);

    public abstract Component BuildParenthesis(Component c);

}