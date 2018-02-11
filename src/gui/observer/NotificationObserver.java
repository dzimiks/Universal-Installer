package gui.observer;


/**
 * Obavestenja (notifikacije) koje koristi klasa Observable
 * za oznacavanje poslatih poruka.
 * 
 * @author Vanja Paunovic
 *
 */
public enum NotificationObserver {

	/**
	 * Dogadjaj dodavanja cvora.
	 */
	ADD,
	/**
	 * Dogadjaj brisanja cvora.
	 */
	DELETE,
	/**
	 * Dogadjaj preimenovanja cvora u stablu.
	 */
	TREE_RENAME,
	/**
	 * Dogadjaj selektovanja stabla.
	 */
	TREE_SELECT,
	/**
	 * Dogadjaj preimenovanja elemenata na glavnom prozoru.
	 */
	MAIN_VIEW_SELECT,
	/**
	 * Dogadjaj preimenovanja cvora.
	 */
	NODE_RENAME,
    /**
     * Promena u listi slobodnih cvorova.
     */
    FREE_NODES_CHANGED
}