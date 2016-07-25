package observerstrategy;

/**
 * @author Lorenzo Cioni
 */
public class StrategyReady implements Strategy {
	
	/**
	 * Private constructor, for singleton
	 */
	private StrategyReady(){}
	private static StrategyReady instance = null;
	
	public static StrategyReady getInstance(){
		if(instance == null){
			instance = new StrategyReady();
		}
		return instance;
	}

    /**
     * Print algorithm
     */
    public State algorithmInterface() {
    	System.out.println("Ready Strategy");
    	return State.READY;
    }

}