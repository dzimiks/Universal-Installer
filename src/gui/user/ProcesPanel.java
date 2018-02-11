package gui.user;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.json.ReadJsonFile;
import gui.model.CopyModule;
import gui.model.CopyParameter;
import gui.model.CopySoftware;
import gui.model.Parameter;
import gui.panels.ImagePanel;

public class ProcesPanel extends JPanel{
	
	private static int br = 0;
	private String[] nazivi = new String[]{
			"1" , "2" , "3" , "4" , "5" , "6" ,
			"7" , "8" , "9" , "10" , "11" , "12" ,
			"13" , "14" , "15" , "16" , "17" , "18" ,
			"19" , "20" , "21" , "22" , "23" , "24" , 
			"25" , "26" , "27" , "28" , "29" , "30" ,
			"31" , "32" , "33" , "34" , "35" , "36" ,
			"37" , "38" , "39" , "40" , "41" , "42" ,
			"43" , "44" , "45" , "46" , "47" , "48" , 
			"49" , "50" , "51" , "52" , "53" , "54"
	};
	private static int brojacZaString;
	private static int brojPanela = 0;
	private ImagePanel imgPanel = new ImagePanel("");
	
	private PathPanel pathPanel;
	
	private ArrayList<Integer> tocIndeksi = new ArrayList<>();
	
	JButton nazadButton;
	JButton daljeButton;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	
	public ProcesPanel(CopyModule module) {
				
		JPanel panelContent = new JPanel();
		CardLayout cardLayout = new CardLayout();
		GridBagLayout gridBagLayout = new GridBagLayout();
		imgPanel = new ImagePanel("");
		
		JPanel dole = new JPanel();
		JPanel gore = new JPanel();
		
		dole.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.insets = new Insets(15, 5, 15, 5);
		
			
			brojacZaString = 0;
			
			//Podesavanje autor labele
			JLabel autorLabel = new JLabel();
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.AUTHOR)){
					autorLabel.setText(copyParameter.getValue());
					//module.getParameters().remove(copyParameter);
				}
			}
			gbc.gridx = 0;
			gbc.gridy = 0;
			dole.add(autorLabel, gbc);
				
			gbc.insets = new Insets(15, 5, 25, 5);

			//Podesavalje loga
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.LOGO)){
					//logoLabel.setText(copyParameter.getValue());
					//module.getParameters().remove(copyParameter);
					 imgPanel = new ImagePanel(copyParameter.getValue());
					 imgPanel.setPreferredSize(new Dimension(50,50));
				}
			}
			gore.setLayout(new GridBagLayout());
			gbc.insets = new Insets(5,10, 5, 10);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gore.add(imgPanel, gbc);
			
			//Podesavanje imena
			JLabel nameLabel = new JLabel();
			int velicina = module.getParameters().size();
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.NAME)){
					nameLabel.setText(copyParameter.getValue());
					nameLabel.setFont(new Font("Ariel", Font.PLAIN, 22));
					//module.getParameters().remove(copyParameter);
					velicina--;
				}
			}
			gbc.gridx = 1;
			gbc.gridy = 0;
			gore.add(nameLabel, gbc);
			
			
			//Podesavanje verzija labele
			JLabel verzijaLabel = new JLabel();
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.VERSION)){
					verzijaLabel.setText(resourceBundle.getString("version") +" "+ copyParameter.getValue());
					//module.getParameters().remove(copyParameter);
				}
			}
			gbc.gridx = 2;
			gbc.gridy = 0;
			gore.add(verzijaLabel, gbc);
			gbc.insets = new Insets(15, 5, 15, 5);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			nazadButton = new JButton(resourceBundle.getString("nazadButton"));
			dole.add(nazadButton, gbc);
			
			nazadButton.setEnabled(false);
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			daljeButton = new JButton(resourceBundle.getString("daljeButton"));
			dole.add(daljeButton, gbc);
			
			JButton cancelInstallation = new JButton(resourceBundle.getString("cancelInstallation"));
			gbc.gridx = 2;
			gbc.gridy = 1;
			dole.add(cancelInstallation , gbc);
			
			setLayout(new BorderLayout());
			add(dole, BorderLayout.SOUTH);
			add(gore , BorderLayout.NORTH);
			
			panelContent.setLayout(cardLayout);
			brojacZaString = 0;
			
			//Dodavanje descriptiona
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.DESCRIPTION)){
					try {
						panelContent.add(new DescriptionPanel(copyParameter), nazivi[brojacZaString]);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					brojacZaString++;
					//module.getParameters().remove(copyParameter);
				}
			}
			
			//Dodavanje TOC - a
			
			for(CopyParameter copyParameter : module.getParameters()){
				if(copyParameter.getType().equals(gui.model.Type.TOC)){
					try {
						panelContent.add(new TocPanel(copyParameter), nazivi[brojacZaString]);
						tocIndeksi.add(new Integer(brojacZaString));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					brojacZaString++;
					//module.getParameters().remove(copyParameter);
				}
			}
			
			
			//cl.show(panelCont, "1");
			add(panelContent , BorderLayout.CENTER);
			
			
			//Custom parametri
			ArrayList<CopyParameter> customParametri = new ArrayList<>();
			for(CopyParameter parametar : module.getParameters()){
				if(parametar.getType().equals(gui.model.Type.CUSTOM)){
					customParametri.add(parametar);
				}
			}
			
			for(int i = 0 ; i < customParametri.size() ; i = i + 4){
	//			if((i + 1) == customParametri.size()){
					panelContent.add(new PromenljiviPanel(customParametri.get(i)), nazivi[brojacZaString]);
					brojacZaString++;
	/**			}else if((i + 2) == customParametri.size()){
					panelContent.add(new PromenljiviPanel(customParametri.get(i) , customParametri.get(i+1)) , 
							nazivi[brojacZaString]);
					brojacZaString ++;
				}else if((i + 3) == customParametri.size()){
					panelContent.add(new PromenljiviPanel(customParametri.get(i) , customParametri.get(i+1) , 
							customParametri.get(i+2)) , nazivi[brojacZaString]);
					brojacZaString ++;
				}else{
					panelContent.add(new PromenljiviPanel(customParametri.get(i) , customParametri.get(i+1) , 
							customParametri.get(i+2)) , nazivi[brojacZaString]);
					brojacZaString ++;
				}				**/
			}
			
			pathPanel = new PathPanel();
			panelContent.add(pathPanel , nazivi[brojacZaString]);
			//brojacZaString++;
			
			//Dodat progres bar
	/**		panelContent.add(new ProgresPanel(1) , nazivi[brojacZaString]);
			//cl.show(panelCont, nazivi[brojacZaString]);
			brojacZaString++;				**/
			
			//Dodate desktop shortcut i start opcije 
	/**		CopyParameter shortcut = null;
			CopyParameter start = null;
			for(CopyParameter parameter : module.getParameters()){
				if(parameter.getType().equals(gui.model.Type.DESKTOP_SHORTCUT)){
					if(parameter.getValue().equals("true")){
						shortcut = parameter;
						shortcut.setValue("create desktop shortcut");
					}
				}
			}
			for(CopyParameter parameter : module.getParameters()){
				if(parameter.getType().equals(gui.model.Type.START)){
					if(parameter.getValue().equals("true")){
						start = parameter;
						start.setValue("start program");
					}
				}
			}
			
			if((start != null) && (shortcut != null)){
				panelContent.add(new ShortcutAndStartPanel(start, shortcut) , nazivi[brojacZaString]);
			}else if(start != null){
				panelContent.add(new ShortcutAndStartPanel(start) , nazivi[brojacZaString]);
			}else if(shortcut != null){
				panelContent.add(new ShortcutAndStartPanel(shortcut) , nazivi[brojacZaString]);
			}else{
				panelContent.add(new ShortcutAndStartPanel() , nazivi[brojacZaString]);
			}				**/
			
		//	cl.show(panelCont, nazivi[brojacZaString]);


		
			
		brojPanela = brojacZaString;
			
		br = 0;
		
		for(Integer a : tocIndeksi){
			if((new Integer(0)).equals(a)){
				daljeButton.setEnabled(false);
			}
		}
		
		cancelInstallation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InstalacijaModulaView.getInstance().dispose();
				KorisnikView.getInstance().setEnabled(true);
				KorisnikView.getInstance().toFront();
				
			}
		});
		
		
		daljeButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if((br) >= brojPanela){
		/**			daljeButton.setEnabled(false);
					nazadButton.setEnabled(false);		**/
					
					// Validacija
					if(pathPanel.getFile() == null || pathPanel.getFile().equals("")){
						JOptionPane.showMessageDialog(null, resourceBundle.getString("procesErrorLbl"), 
									resourceBundle.getString("procesErrorTitle"),JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					InstalacijaModulaView.getInstance().changeContentPane(new ProgresPanel(pathPanel.getFile() , module));
				}
				
				cardLayout.next(panelContent);
				
				if((br + 1) < brojPanela){
					nazadButton.setEnabled(true);
				}				
				
				for(Integer a : tocIndeksi){
					if((new Integer(br + 1)).equals(a)){
						daljeButton.setEnabled(false);
					}
				}
				br++;
			}
		});
		
		nazadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	cl.show(panelCont, nazivi[brojacZaString]);
			//	brojacZaString++;					
				cardLayout.previous(panelContent);
			//	brojacZaString -= 2;
				if(br == 1){
					nazadButton.setEnabled(false);
				}
				daljeButton.setEnabled(true);
				for(Integer a : tocIndeksi){
					if((new Integer(br + 1)).equals(a)){
						daljeButton.setEnabled(false);
					}
				}
				br--;
			}
		});
		
	
	}
	
	public JButton getDaljeButton(){
		return daljeButton;
	}

	
	
}
