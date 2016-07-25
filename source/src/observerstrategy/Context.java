package observerstrategy;

import java.util.*;

/**
 * @author Lorenzo Cioni
 */
public class Context implements Observer {
	
	private Strategy strategy;
	private Monitor monitor;
	private State state;
	
    /**
     * Default constructor
     */
    public Context(Strategy s, Monitor m) {
    	this.monitor = m;
    	this.strategy = s;
    	state = m.getState();
    }

    /**
     * Updates monitor
     */
    public void update() {
        state = monitor.getState();
        switch (state) {
		case READY:
			strategy = StrategyReady.getInstance();
			break;
		case ON:
			strategy = StrategyOn.getInstance();
			break;
		case OFF:
			strategy = StrategyOff.getInstance();
			break;
		default:
			break;
		}  
    }

    public State contextInterface() {
        return strategy.algorithmInterface();
    }

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}