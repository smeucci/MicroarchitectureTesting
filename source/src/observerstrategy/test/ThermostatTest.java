package observerstrategy.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.*;

import observerstrategy.Device;
import observerstrategy.State;
import observerstrategy.Strategy;
import observerstrategy.StrategyReady;
import observerstrategy.Subject;
import observerstrategy.TemperatureSensor;
import observerstrategy.Thermostat;
import observerstrategy.Updater;
import observerstrategy.Controller;

public class ThermostatTest {
	
	@Mock
	private TemperatureSensor sensor;
	private Controller controller;
	private Device device;
	private Thermostat thermostat;
	private Updater updater;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Strategy strategy = StrategyReady.getInstance();
		device = new Device();
		device.setSensor(sensor);
		controller = new Controller(strategy, device);
		device.attachObserver(controller);
		
		thermostat = new Thermostat();
		thermostat.addObject(controller);
		//Initialize thermostat to 20 degrees
		thermostat.setTemperature(20);
		
		//Initialize updater for time passing simulation
		updater = new Updater(device);		
	}
	
	/**
	 * Test: 1
	 * Descrizione: verifica il cambio di stato
	 */
	@Test
	public void stateChangeTest(){
		when(sensor.getTemperature()).thenReturn(20);
		updater.update();
		assertEquals("State of the controller must be READY when temperature is equal to the set one", State.READY, controller.getState());
		when(sensor.getTemperature()).thenReturn(18);
		updater.update();
		assertEquals("State of the controller must be ON when temperature is equal to the set one", State.ON, controller.getState());
		when(sensor.getTemperature()).thenReturn(22);
		updater.update();
		assertEquals("State of the controller must be OFF when temperature is equal to the set one", State.OFF, controller.getState());		
	}
	
	/**
	 * Test: 2
	 * Descrizione: verifica inizialmente tutti impostati su ready
	 */
	@Test
	public void initialStateTest(){
		assertEquals("Initial state of the controller is not READY", State.READY, controller.getState());
	}

}
