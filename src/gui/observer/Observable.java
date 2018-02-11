package gui.observer;


/**
 * Implementacija interfejsa Observable.
 * 
 * @author Vanja Paunovic
 *
 */
public interface Observable {

	/**
	 * Registruje novi observer.
	 * 
	 * @param observer
	 * 			novi observer koji ce biti dodat
	 */
	public void addObserver(MainObserver observer);
}