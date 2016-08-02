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
    	Component not = builder.BuildNot(varz);
    	Component or = builder.BuildOr(par, not);
    	
    	System.out.print("# ");
    	or.draw();
    	System.out.println(" --> evaluation: " + or.evaluate());
    	
    }
    
    public void ConstructGenericExpr(String[] ops, Boolean[] bs) {
    	
    	int i = 0;
    	int j = 0;
    	Component[] components = new Component[100];
    	
    	for (int h = 0; h < ops.length; h++) {
    		
    		if (ops[h] == "var") {
    			components[i] = builder.BuildVariable("var" + String.valueOf(i), bs[j]);
    			i++;
    			j++;
    		}
    		
    		if (ops[h] == "par") {
    			components[i] = builder.BuildParenthesis(components[i - 1]);
    			i++;
    		}
    		
    		if (ops[h] == "and") {
    			components[i] = builder.BuildAnd(components[i - 2], components[i - 1]);
    			i++;
    		}
    		
    		if (ops[h] == "or") {
    			components[i] = builder.BuildOr(components[i - 2], components[i - 1]);
    			i++;
    		}
    		
    	}
    	
    	System.out.print("# ");
    	components[i - 1].draw();
    	System.out.println(" --> evaluation: " + components[i - 1].evaluate());
    	
    }
    
}