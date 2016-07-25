package observerstrategy;

import java.util.*;

/**
 * @author Lorenzo Cioni
 */
public class Monitor extends Subject {
	private State state;

    /**
     * Default constructor
     */
    public Monitor() {
    	state = State.READY;
    }

    /**
     * Get and set state
     */
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        notifyObservers();
    }

}