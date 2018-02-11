package gui.user;


import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import gui.json.ReadJsonFile;
import gui.model.CopyParameter;
import gui.model.CopySoftware;
import gui.model.Parameter;
import gui.panels.SoftwarePanel;
import gui.view.MainView;

@SuppressWarnings("unused")
public class KorisnikView extends JFrame{
	
	private static KorisnikView instance = null;
	
	private CopySoftware copySoftware;
	
	private SoftwarePanel panel;
	
	
	private KorisnikView(){
				
		initialise();
	}
	

	private void initialise() {
		
		File fajl = new File(((SoftwarePanel) MainView.getInstance().getPanRight()).getChosenFile());
		copySoftware = ((SoftwarePanel) MainView.getInstance().getPanRight()).getCopySoftware();
		

		setTitle(copySoftware.getName());		
		
		PanelJezik prvi = new PanelJezik(copySoftware ,0);
		this.setContentPane(prvi);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);	
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				MainView.getInstance().setEnabled(true);
				
			}
		});
		 
	}
	
	public static KorisnikView getInstance(){
		if(instance == null){
			instance = new KorisnikView();
		}
		return instance;
	}
	
	public void changeContentPane(JPanel pnl){
		this.setContentPane(pnl);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void changeSize(int a , int b){
		this.setSize(a , b);
	}
	
	
	public CopySoftware getList(){
		return copySoftware;
	}

	@Override
	public void setVisible(boolean b) {
		File fajl = new File(((SoftwarePanel) MainView.getInstance().getPanRight()).getChosenFile());
		copySoftware = ((SoftwarePanel) MainView.getInstance().getPanRight()).getCopySoftware();
		

		setTitle(copySoftware.getName());		
		
		PanelJezik prvi = new PanelJezik(copySoftware ,0);
		this.setContentPane(prvi);
		super.setVisible(b);
	}
	
	@Override
	public void setEnabled(boolean b) {
		try {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setEnabled(b);
	}
}
