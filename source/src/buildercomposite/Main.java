package buildercomposite;

public class Main {
   
	public static void main(String args[]) {
		
		ConcreteExprBuilder builder = new ConcreteExprBuilder();
		Director director = new Director(builder);
		director.ConstructExpr(true, false, false);
		
		String[] ops = {"var", "var", "and", "par", "var", "or"};
		Boolean[] bs = {true, false, true};
		director.ConstructGenericExpr(ops, bs);
	
	}
	
}
