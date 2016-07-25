package observerstrategy;

public class Main {

	public static void main(String[] args){
		Monitor m = new Monitor();
		Strategy s;
		s = StrategyReady.getInstance();
		Context c = new Context(s, m);
		m.attachObserver(c);
		
		c.contextInterface();
		
		m.setState(State.ON);
		c.contextInterface();
		
		m.setState(State.OFF);
		c.contextInterface();
	}
}
