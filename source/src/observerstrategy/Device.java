package observerstrategy;

import java.util.*;

/**
 * @author Lorenzo Cioni
 */
public class Device extends Subject {
	private int temperature;
	private TemperatureSensor sensor;

    /**
     * Default constructor
     */
    public Device() {
    	temperature = 0;
    }

    /**
     * Get and set state
     */
    public int updateTemperature() {
    	temperature = sensor.getTemperature();
    	notifyObservers();
        return temperature;
    }
    
    public int getTemperature(){
    	return temperature;
    }

	public TemperatureSensor getSensor() {
		return sensor;
	}

	public void setSensor(TemperatureSensor sensor) {
		this.sensor = sensor;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}