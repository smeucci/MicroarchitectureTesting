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
    public int getTemperature() {
    	temperature = sensor.getTemperature();
    	notifyObservers();
        return temperature;
    }
}