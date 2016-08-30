package buildercomposite;

public class Main {
   
	public static void main(String args[]) {
		
		ExprBuilder builder = new ConcreteExprBuilder();
		Director director = new Director(builder);
		director.ConstructExpr(true, false, true);
		
//		String[] ops = {"var", "var", "and", "par", "var", "or", "var", "and"};
//		Boolean[] bs = {true, true, true, false};
//		director.ConstructGenericExpr(ops, bs);
	
	}
	
}
