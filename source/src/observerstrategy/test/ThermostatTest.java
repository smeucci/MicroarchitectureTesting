package observerstrategy.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.*;

import observerstrategy.Context;
import observerstrategy.Device;
import observerstrategy.State;
import observerstrategy.Strategy;
import observerstrategy.StrategyReady;
import observerstrategy.Subject;
import observerstrategy.TemperatureSensor;
import observerstrategy.Controller;

public class ThermostatTest {
	
	@Mock
	private TemperatureSensor sensor;
	private Controller thermostat;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Strategy strategy = StrategyReady.getInstance();
		Context context;
		ArrayList<Device> objects = new ArrayList<Device>();
		Device m1 = new Device();
		context = new Context(strategy, m1);
		m1.attachObserver(context);
		Device m2 = new Device();
		context = new Context(strategy, m2);
		m2.attachObserver(context);
		Device m3 = new Device();
		context = new Context(strategy, m3);
		m3.attachObserver(context);
				
		objects.add(m1);
		objects.add(m2);
		objects.add(m3);
		
		thermostat = new Controller(objects);
		thermostat.setSensor(sensor);
	}
	
	/**
	 * Test: 1
	 * Descrizione: verifica il cambio di stato
	 */
	@Test
	public void stateChangeTest(){
		thermostat.setTemperature(20);
		when(sensor.getTemperature()).thenReturn(20);
		thermostat.update();
		when(sensor.getTemperature()).thenReturn(18);
		thermostat.update();
		when(sensor.getTemperature()).thenReturn(22);
		thermostat.update();
	}
	
	/**
	 * Test: 2
	 * Descrizione: verifica inizialmente tutti impostati su ready
	 */
	@Test
	public void initialStateTest(){
		for(Device subject: thermostat.getObjects()){
			assertEquals("Initial state of the object not READY", State.READY, subject.getState());
		}
	}

}
