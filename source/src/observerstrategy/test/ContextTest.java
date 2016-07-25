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

	@Before
	public void setup() throws Exception {
		Monitor m = new Monitor();
		Strategy s;
		s = StrategyReady.getInstance();
		context = new Context(s, m);
	}

	/**
	 * Test: 1
	 * Descrizione: inizialmente lo stato del soggetto monitorato deve essere 
	 * impostato a READY
	 */
	@Test
	public void initialStateTest(){
		assertEquals("Initial state not set to READY", State.ON, context.getState());
	}
	
	/**
	 * Test: 2
	 * Descrizione: il metodo update si comporta in modo diverso a seconda
	 * dello stato del soggetto rilevato dal monitor. In caso di staato READY
	 * utilizzerò la strategia READY, etc.
	 */
	

	/**
	 * Test: 3
	 * Descrizione: la strategia da come risultato quello atteso
	 
	 */
	
	/**
	 * Test: 4
	 * Descrizione: al cambio di stato corrisponde una notifica agli observers
	 */
	
	/**
	 * Test: 5
	 * Descrizione: la registrazione dell'observer va a buon fine
	 */
}
