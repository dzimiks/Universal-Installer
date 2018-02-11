package gui.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import gui.constants.Constants;
import gui.model.CopyModule;


public class ProgresPanel extends JPanel{
    
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());

	private static int naziv = 0;
	final JProgressBar progressbar = new JProgressBar();
	private JLabel progressLabel = new JLabel(resourceBundle.getString("progressLabel"));
	private JButton daljeButton;
	private String gde;
	
	public ProgresPanel(int mod) {
			

			  
		if(mod == 2){
			daljeButton = new JButton("Next");
			
			daljeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					KorisnikView.getInstance().changeContentPane(new EndPanel());
					
				}
			});
		}
			  if(mod == 2){
				  daljeButton.setEnabled(false);
			  }
			
			  progressbar.setStringPainted(true);
			  progressbar.setValue(0);
			  
			  int timerDelay = 10;
			  new Timer(timerDelay , new ActionListener() {
			     private int index = 0;
			     private int maxIndex = 100;
			     public void actionPerformed(ActionEvent e) {
			        if (index < maxIndex) {
			           progressbar.setValue(index);
			           index++;
			        } else {
			           progressbar.setValue(maxIndex);
			           ((Timer)e.getSource()).stop(); // zaustavi tajmer
			        }
			        if(progressbar.getValue() == maxIndex){
			        	daljeButton.setEnabled(true);
			        }
			     }
			  }).start();
			  
			  progressbar.setValue(progressbar.getMinimum());
			  
			  
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		add(progressLabel , c);
		c.insets = new java.awt.Insets(10 , 10 , 10 , 10);
		c.gridx = 0;
		c.gridy = 1;
		add(progressbar,c);
		c.gridx = 0;
		c.gridy = 2;
		if(mod == 2){
			add(daljeButton , c);
		}
	}
	public ProgresPanel(String lokacija , CopyModule module) {
		
		
		lokacija = lokacija + File.separator + module.getName();
			
		System.out.println(module.getLockPath());
		String[] s = module.getLockPath().split("\\.");
		lokacija = lokacija+ String.valueOf(naziv) + "."  + s[1];
		naziv++;
		File sourceFile = new File(module.getLockPath());
		File destinationFile = new File(lokacija);
		Path sourcePath = sourceFile.toPath();
		Path destinationPath = destinationFile.toPath();
		try {
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 daljeButton = new JButton("Next");
		 daljeButton.setEnabled(false);
		 progressbar.setStringPainted(true);
		  progressbar.setValue(0);
		  
		  int timerDelay = 10;
		  new Timer(timerDelay , new ActionListener() {
		     private int index = 0;
		     private int maxIndex = 100;
		     public void actionPerformed(ActionEvent e) {
		        if (index < maxIndex) {
		           progressbar.setValue(index);
		           index++;
		        } else {
		           progressbar.setValue(maxIndex);
		           ((Timer)e.getSource()).stop(); // zaustavi tajmer
		        }
		        if(progressbar.getValue() == maxIndex){
		        	daljeButton.setEnabled(true);
		        }
		     }
		  }).start();
		  
		  setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			add(progressLabel , c);
			c.insets = new java.awt.Insets(10 , 10 , 10 , 10);
			c.gridx = 0;
			c.gridy = 1;
			add(progressbar,c);
			c.gridx = 0;
			c.gridy = 2;
			add(daljeButton , c);
			
			gde = lokacija;
			
			daljeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

					InstalacijaModulaView.getInstance().changeContentPane(new ShortcutAndStartPanel(module , gde));
					
				}
			});
	}
}
