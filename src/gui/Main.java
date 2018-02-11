package gui;

import gui.view.MainView;

public class Main {
	/***
	 * OBJECT MAPER
	 * @param args
	 */
	public static void main(String[] args) {
		MainView view = MainView.getInstance();
		view.setVisible(true);
	}
}