package observerstrategy;

/**
 * @author Lorenzo Cioni
 */
public class StrategyOn implements Strategy {

	/**
	 * Private constructor, for singleton
	 */
	private StrategyOn(){}
	private static StrategyOn instance = null;
	
	public static StrategyOn getInstance(){
		if(instance == null){
			instance = new StrategyOn();
		}
		return instance;
	}

    /**
     * Print algorithm
     */
    public State algorithmInterface() {
    	System.out.println("On Strategy");
    	return State.ON;
    }

}