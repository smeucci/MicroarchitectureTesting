package observerstrategy;

import java.util.*;

public class Updater {
	
	private ArrayList<Device> devices;
	
	public Updater(Device dev){
		if(devices == null){
			devices = new ArrayList<Device>();
		}
		devices.add(dev);
	}
	
	public Updater(ArrayList<Device> devices){
		this.devices = devices;
	}
	
	/**
	 * Simulate the passing time asking for device to update the temperature
	 */
	public void update(){
		for(Device device: devices){
			device.getTemperature();
		}
	}

}
