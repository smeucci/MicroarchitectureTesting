package observerstrategy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import observerstrategy.Context;
import observerstrategy.Monitor;
import observerstrategy.Strategy;
import observerstrategy.StrategyReady;

public class SubjectTest {

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
	 * Test: 5
	 * Descrizione: inizialmente gli observer associati al soggetto sono 0
	 */
	@Test
	public void checkInitialObservers(){
		assertEquals("Observer not attached correctly", 0, monitor.getObservers().size());
	}
	
	/**
	 * Test: 6
	 * Descrizione: l'aggiunta di un nuovo observer va a buon fine
	 */
	@Test
	public void addObserverCorrect(){
		int past = monitor.getObservers().size();
		monitor.attachObserver(context);
		int current = monitor.getObservers().size();
		assertEquals("Observer not attached correctly", past + 1, current);
	}
	
	/**
	 * Test: 7
	 * Descrizione: la rimozione di un observer decrementa il numero di observer di uno
	 */
	@Test
	public void removeObserverCorrect(){
		monitor.attachObserver(context);
		int past = monitor.getObservers().size();
		monitor.detachObserver(context);
		int current = monitor.getObservers().size();
		assertEquals("Observer not deattached correctly", past - 1, current);
	}

}
