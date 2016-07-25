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
    public void algorithmInterface() {
    	System.out.println("Ho eseguito l'operazione utilizzando la Strategia Off");
    }

}