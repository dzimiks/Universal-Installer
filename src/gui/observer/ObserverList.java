package gui.observer;

import java.util.ArrayList;

/**
 * Klasa koja sadrzi listu observera koji ce biti 
 * odrzavani klasom Observable.
 * 
 * @author Vanja Paunovic
 * 
 */
public class ObserverList {

	private ArrayList<MainObserver> observers;

	public ObserverList() {
		observers = new ArrayList<>();
	}
	
	/**
	 * Salje poruku svim registrovanim observerima.
	 * 
	 * @param notification
	 * 			obavestenje o odlaznim porukama
	 * @param obj
	 * 			pomocni objekat koji se salje sa porukom
	 */
	public void notifyObservers(NotificationObserver notification, Object obj) {
		for (MainObserver obs : observers)
			obs.update(notification, obj);
	}
	
	/**
	 * Registruje novi observer.
	 * 
	 * @param observer
	 * 			novi observer koji ce biti dodat
	 */
	public void addObserver(MainObserver observer) {
		observers.add(observer);
	}
}