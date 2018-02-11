package gui.user;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.model.CopyModule;
import gui.model.CopyParameter;

public class InstalacijaModulaView extends JFrame{
	
	private CopyParameter kopija;
	
	private static InstalacijaModulaView instance = null;
	private CopyModule module;
	
	private InstalacijaModulaView() {
		initialise();
	}
	
	private void initialise(){
		module = ((SpisakModulaPanel)KorisnikView.getInstance().getContentPane()).getModule();
		setTitle(module.getName());
		
		//System.out.println("br " + ((SpisakModulaPanel)KorisnikView.getInstance().getContentPane()).getA());
/**		boolean ima = false;
		for(CopyParameter p : module.getParameters()){
			if(p.getType().equals(gui.model.Type.LANGUAGE)){
				ima = true;
			}
		}
		
		if(ima){
			JezikPanel panel = new JezikPanel(module);
			changeContentPane(panel);
		}else{
			ProcesPanel panel2 = new ProcesPanel(module);
			changeContentPane(panel2);
		}			**/
		
		
	//	this.setVisible(true);
		this.setSize(550, 550);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {
		    public void WindowClosing(WindowEvent e) {
		        KorisnikView.getInstance().setEnabled(true);
		        KorisnikView.getInstance().toFront();
		        dispose();
		    }
		});
	}
	
	public void changeContentPane(JPanel pnl){
		this.setContentPane(pnl);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public static InstalacijaModulaView getInstance(){
		if(instance == null){
			instance = new InstalacijaModulaView();
		}
		return instance;
	}
	
	@Override
	public void setVisible(boolean b) {
		module = ((SpisakModulaPanel)KorisnikView.getInstance().getContentPane()).getModule();
		setTitle(module.getName());
		
		//System.out.println("br " + ((SpisakModulaPanel)KorisnikView.getInstance().getContentPane()).getA());
		boolean ima = false;
		for(CopyParameter p : module.getParameters()){
			if(p.getType().equals(gui.model.Type.LANGUAGE)){
				ima = true;
			}
		}
		
		if(ima){
			JezikPanel panel = new JezikPanel(module);
			changeContentPane(panel);
		}else{
			ProcesPanel panel = new ProcesPanel(module);
			changeContentPane(panel);
		}
		boolean tacno = false;
		for(CopyParameter p : module.getParameters()){
			if(p.getType().equals(gui.model.Type.LOOKNFEEL)){
				kopija = p;
				tacno = true;
				
		}
		}
		if(tacno){
		try {
			UIManager.setLookAndFeel(kopija.getValue());
			SwingUtilities.updateComponentTreeUI(InstalacijaModulaView.getInstance());
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
		}
		super.setVisible(b);
	}
	
}
