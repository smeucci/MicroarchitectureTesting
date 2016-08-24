package observerstrategy;

public class Main {

	public static void main(String[] args){
		
		
		
		
		Device d = new Device();
		Strategy s = StrategyReady.getInstance();
		
		Controller controller = new Controller(s, d);
		d.attachObserver(controller);
		
		Updater updater = new Updater(d);
		
		updater.update();
		
	}
}
