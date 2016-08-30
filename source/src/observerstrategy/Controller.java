package observerstrategy;

import java.util.*;

/**
 * @author lorenzocioni
 *
 */
public class Controller implements Observer {
	
	private Strategy strategy;
	private int temperature;
	private Device device;
	private State state;
	
	public Controller(Strategy strat, Device object) {
		this.strategy = strat;
		this.device = object;
		this.state = State.READY;
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}
	
	public void update() {
		int temperature = device.getTemperature();
		if(temperature > this.temperature){
			strategy = StrategyOff.getInstance();
			state = State.OFF;
		} else if(temperature == this.temperature){
			strategy = StrategyReady.getInstance();
			state = State.READY;
		} else if(temperature < this.temperature){
			strategy = StrategyOn.getInstance();
			state = state.ON;
		}	
		strategy.work();
	}
	
	public void timeUpdate(){
		device.updateTemperature();
	}


	public Device getObject() {
		return device;
	}

	public void setObject(Device object) {
		this.device = object;
	}
	
	public State getState(){
		return state;
	}

}
