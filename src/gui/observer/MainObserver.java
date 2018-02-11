package gui.observer;


/**
 * Implementacija interfejsa Observer.
 *
 * @author Vanja Paunovic
 *
 */
public interface MainObserver {

	/**
	 * Salje poruku svim registrovanim observerima.
	 * 
	 * @param notification
	 * 			obavestenje o odlaznim porukama
	 * @param obj
	 * 			pomocni objekat koji se salje sa porukom
	 */
	public void update(NotificationObserver notification, Object obj);
}