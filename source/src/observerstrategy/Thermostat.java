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
	
	public void addObject(Controller obj){
		if(objects == null){
			objects = new ArrayList<Controller>();
		}
		objects.add(obj);
	}

	public ArrayList<Controller> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Controller> objects) {
		this.objects = objects;
	}
	
	

}
