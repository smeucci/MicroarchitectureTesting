package observerstrategy;

import java.util.*;

public class Thermostat {
	
	private ArrayList<Controller> objects;
	
	public Thermostat(){}
	
	public void setTemperature(int temperature){
		for(Controller controller: objects){
			controller.setTemperature(temperature);
		}
	}

	public ArrayList<Controller> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Controller> objects) {
		this.objects = objects;
	}
	
	

}
