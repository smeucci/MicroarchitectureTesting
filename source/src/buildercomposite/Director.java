package buildercomposite;

/**
 * 
 */
public class Director {

	private ExprBuilder builder;
	
    public Director(ExprBuilder builder) {
    	this.builder = builder;
    }
    
    public void ConstructExpr(Boolean x, Boolean y, Boolean z) {
        
    	Component varx = builder.BuildVariable("X", x);
    	Component vary = builder.BuildVariable("Y", y);
    	Component and = builder.BuildAnd(varx, vary);
    	Component par = builder.BuildParenthesis(and);
    	Component varz = builder.BuildVariable("Z", z);
    	Component or = builder.BuildOr(par, varz);
    	
    	System.out.print("# ");
    	or.draw();
    	System.out.println(" --> evaluation: " + or.evaluate());
    	
    }

}