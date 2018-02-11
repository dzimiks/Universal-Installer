package gui.commands;

/**
 * Kreira i poziva sve komande po komandnom obrascu.
 * 
 * @author Vanja Paunovic
 *
 */
public class Invoker {

	protected static Invoker instance = null;
	
	protected Invoker() {
		
	}
	
	public static Invoker getInstance() {
		if (instance == null) {
			instance = new Invoker();
		}

		return instance;
	}

	public void executeCommand(Command command) {
		command.doCommand();
	}
}