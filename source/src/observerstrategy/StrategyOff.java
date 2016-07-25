package observerstrategy;

/**
 * @author Lorenzo Cioni
 */
public class StrategyOff implements Strategy {

	/**
	 * Private constructor, for singleton
	 */
	private StrategyOff(){}
	private static StrategyOff instance = null;
	
	public static StrategyOff getInstance(){
		if(instance == null){
			instance = new StrategyOff();
		}
		return instance;
	}

    /**
     * Print algorithm
     */
    public State algorithmInterface() {
    	System.out.println("Off Strategy");
    	return State.OFF;
    }

}