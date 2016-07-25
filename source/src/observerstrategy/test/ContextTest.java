package observerstrategy.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import observerstrategy.Context;
import observerstrategy.Monitor;
import observerstrategy.State;
import observerstrategy.Strategy;
import observerstrategy.StrategyReady;

public class ContextTest {
	
	private Context context;
	private Monitor monitor;

	@Before
	public void setup() throws Exception {
		monitor = new Monitor();
		Strategy s;
		s = StrategyReady.getInstance();
		context = new Context(s, monitor);
	}

	/**
	 * Test: 1
	 * Descrizione: inizialmente lo stato del soggetto monitorato deve essere 
	 * impostato a READY
	 */
	@Test
	public void initialStateTest(){
		assertEquals("Initial state not set to READY", State.READY, context.getState());
	}
	
	/**
	 * Test: 2
	 * Descrizione: il metodo update si comporta in modo diverso a seconda
	 * dello stato del soggetto rilevato dal monitor. In caso di stato READY
	 * utilizzerò la strategia READY, etc. e la strategia da come risultato quello atteso
	 */
	@Test
	public void updateChangesState(){
		monitor.attachObserver(context);
		monitor.setState(State.READY);
		assertEquals("Ready strategy not called proprerly", State.READY, context.contextInterface());
		monitor.setState(State.ON);
		assertEquals("On strategy not called proprerly", State.ON, context.contextInterface());
		monitor.setState(State.OFF);
		assertEquals("Off strategy not called proprerly", State.OFF, context.contextInterface());
	}

}
