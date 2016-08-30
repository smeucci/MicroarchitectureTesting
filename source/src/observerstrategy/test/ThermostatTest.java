package observerstrategy.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import observerstrategy.Device;
import observerstrategy.State;
import observerstrategy.Strategy;
import observerstrategy.StrategyOff;
import observerstrategy.StrategyReady;
import observerstrategy.TemperatureSensor;
import observerstrategy.Thermostat;
import observerstrategy.Controller;

public class ThermostatTest {
	
	@Mock
	private TemperatureSensor sensor;
	private Controller controller;
	private Device device;
	private Thermostat thermostat;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Strategy strategy = StrategyReady.getInstance();
		device = new Device();
		device.setSensor(sensor);
		controller = new Controller(strategy, device);
		
		thermostat = new Thermostat();
		thermostat.addObject(controller);
		//Initialize thermostat to 20 degrees
		thermostat.setTemperature(20);

	}
	
	/**
	 * Number: 1
	 * Title: Initial state test
	 * Description: Initially the state of the subject is set to READY
	 */
	@Test
	public void initialStateTest(){
		assertEquals("Initial state of the controller is not READY", State.READY, controller.getState());
	}
	
	
	/**
	 * Number: 2
	 * Title: Update temperature test
	 * Description: The thermostat acts differently based on device temperature, updating controller 
	 * state and using correct strategy: if device temperature is lower than the thermostat temperature 
	 * state is set to ON, if they are equal, the state is set to READY, OFF otherwise.
	 */
	@Test
	public void stateChangeTest(){
		device.attachObserver(controller);
		when(sensor.getTemperature()).thenReturn(20);
		controller.timeUpdate();
		assertEquals("State of the controller must be READY when temperature is equal to the set one", State.READY, controller.getState());
		when(sensor.getTemperature()).thenReturn(18);
		controller.timeUpdate();
		assertEquals("State of the controller must be ON when temperature is equal to the set one", State.ON, controller.getState());
		when(sensor.getTemperature()).thenReturn(22);
		controller.timeUpdate();
		assertEquals("State of the controller must be OFF when temperature is equal to the set one", State.OFF, controller.getState());		
	}
	
	/**
	 * Number: 3
	 * Title: Check initial observers
	 * Description: The number of observers when a new subject instance is created is 0
	 */
	@Test
	public void checkInitialObservers(){
		assertEquals("Observer not attached correctly", 0, device.getObservers().size());
	}
	
	/**
	 * Number: 4
	 * Title: Add observer to a subject
	 * Description: When a new observer is attached to the subject, the number of the observers increments by 1
	 */
	@Test
	public void addObserverCorrect(){
		int past = device.getObservers().size();
		device.attachObserver(controller);
		int current = device.getObservers().size();
		assertEquals("Observer not attached correctly", past + 1, current);
	}
	
	/**
	 * Number: 5
	 * Title: Remove observer
	 * Description: When a observer is detached from the subject, the number of the observers decreases by 1
	 */
	@Test
	public void removeObserverCorrect(){
		device.attachObserver(controller);
		int past = device.getObservers().size();
		device.detachObserver(controller);
		int current = device.getObservers().size();
		assertEquals("Observer not deattached correctly", past - 1, current);
	}
	
	/**
	 * Number: 6
	 * Title: Notify observers
	 * Description: When the temperature updates, all the observers attached to the subjects are notified
	 */
	@Test
	public void notifyAllObservers(){		
		Strategy strategy = StrategyOff.getInstance();
		Controller controller1 = new Controller(strategy, device);
		Controller controller2 = new Controller(strategy, device);
		Controller controller3 = new Controller(strategy, device);
		
		thermostat.addObject(controller1);
		thermostat.addObject(controller2);
		thermostat.addObject(controller3);
		thermostat.setTemperature(20);
		
		when(sensor.getTemperature()).thenReturn(15);
		
		device.attachObserver(controller1);
		device.attachObserver(controller2);
		device.attachObserver(controller3);
		
		//Simulate passing time
		controller1.timeUpdate();
		
		//If all controller's states are set to ON,they have been all notified
		assertEquals("First controller must be set to ON", State.ON, controller1.getState());
		assertEquals("Second controller must be set to ON", State.ON, controller2.getState());
		assertEquals("Third controller must be set to ON", State.ON, controller3.getState());
	}
	
	/**
	 * Number: 7
	 * Title: Correct strategy calls
	 * Description: When a state is set to the controller, the correct strategy is executed
	 */
	

}
