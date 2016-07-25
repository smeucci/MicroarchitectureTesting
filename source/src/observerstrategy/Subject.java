package observerstrategy;

import java.util.*;

/**
 * @author Lorenzo Cioni
 */
public class Subject {
	
	private ArrayList<Observer> observers; 

    /**
     * Default constructor
     */
    public Subject() {
    	observers = new ArrayList<Observer>();
    }

    /**
     * Add an observer to the subject
     * @param Observer
     */
    public void attachObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Remove an observer from the subject
     * @param Observer
     */
    public void detachObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Wakes observers and updates
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
			observer.update();
		}
    }

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
    
    

}