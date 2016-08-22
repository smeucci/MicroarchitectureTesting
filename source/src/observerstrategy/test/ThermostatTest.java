package observerstrategy.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.*;

import observerstrategy.Context;
import observerstrategy.Monitor;
import observerstrategy.State;
import observerstrategy.Strategy;
import observerstrategy.StrategyReady;
import observerstrategy.Subject;
import observerstrategy.TemperatureSensor;
import observerstrategy.Thermostat;

public class ThermostatTest {
	
	@Mock
	private TemperatureSensor sensor;
	private Thermostat thermostat;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Strategy strategy = StrategyReady.getInstance();
		Context context;
		ArrayList<Monitor> objects = new ArrayList<Monitor>();
		Monitor m1 = new Monitor();
		context = new Context(strategy, m1);
		m1.attachObserver(context);
		Monitor m2 = new Monitor();
		context = new Context(strategy, m2);
		m2.attachObserver(context);
		Monitor m3 = new Monitor();
		context = new Context(strategy, m3);
		m3.attachObserver(context);
				
		objects.add(m1);
		objects.add(m2);
		objects.add(m3);
		
		thermostat = new Thermostat(objects);
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
		for(Monitor subject: thermostat.getObjects()){
			assertEquals("Initial state of the object not READY", State.READY, subject.getState());
		}
	}

}
