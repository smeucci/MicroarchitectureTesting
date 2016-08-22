package observerstrategy;

import java.util.*;

/**
 * @author lorenzocioni
 *
 */
public class Thermostat {
	
	private int temperature;
	private TemperatureSensor sensor;
	private ArrayList<Monitor> objects;
	
	public Thermostat(ArrayList<Monitor> subjects) {
		this.objects = subjects;
	}
	
	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void update() {
		int temperature = sensor.getTemperature();
		State current = State.OFF;
		if(temperature > this.temperature){
			current = State.OFF;
		} else if(temperature == this.temperature){
			current = State.READY;
		} else if(temperature < this.temperature){
			current = State.ON;
		}
		
		for (Monitor subject : objects) {
			subject.setState(current);
		}
	}

	public TemperatureSensor getSensor() {
		return sensor;
	}

	public void setSensor(TemperatureSensor sensor) {
		this.sensor = sensor;
	}

	public ArrayList<Monitor> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Monitor> objects) {
		this.objects = objects;
	}

}
