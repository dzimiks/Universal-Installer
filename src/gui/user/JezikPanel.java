package gui.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.model.CopyModule;
import gui.model.CopyParameter;

public class JezikPanel extends JPanel{
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	
	private JLabel jezikLabel = new JLabel("Choose preferred language:");	
	private JButton jezikDugme = new JButton("OK");
	
	
	String[] s;
	String[] jezik = new String[]{
			"English" , "Srpski latinica" , "Српска ћирилица"
	};
	JComboBox<String> izaberiJezikCombo = new JComboBox<>();
	
	boolean found = false;
	
	public JezikPanel(CopyModule module) {
		
		//resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());

		CopyParameter cp = new CopyParameter();
		for(CopyParameter parameter : module.getParameters()){
			if((parameter.getType().equals(gui.model.Type.LANGUAGE )) && (!found)){
					String a = parameter.getValue();
					s = a.split("-");					
					cp = parameter;
					found = true;
			}
		}
		
		if(found) {
			module.getParameters().remove(cp);
		}
		if(s[0].equals("true")){
			izaberiJezikCombo.addItem(jezik[0]);
		}
		
		if(s[1].equals("true")){
			izaberiJezikCombo.addItem(jezik[1]);
		}
		
		if(s[2].equals("true")){
			izaberiJezikCombo.addItem(jezik[2]);
		}
		
		izaberiJezikCombo.setEditable(false);
		izaberiJezikCombo.setMaximumSize(new Dimension(300, 45));
		izaberiJezikCombo.setMinimumSize(new Dimension(300, 45));
		izaberiJezikCombo.setAlignmentY(CENTER_ALIGNMENT);	
		jezikDugme.setAlignmentY(CENTER_ALIGNMENT);
		
		izaberiJezikCombo.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(izaberiJezikCombo.getSelectedItem().equals("English")){
					Locale.setDefault(new Locale("en","US"));
					updateLanguage();
				}
				else if(izaberiJezikCombo.getSelectedItem().equals("Srpski latinica")){
					Locale.setDefault(new Locale("sr","RS"));
					updateLanguage();
				}else{
					Locale.setDefault(new Locale("sr","Cyrl_RS"));
					updateLanguage();
				}
				
			}
		});
		
		
		jezikDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean more = false;
				for(CopyParameter par : module.getParameters()){
					if(par.getType().equals(gui.model.Type.LANGUAGE)){
						more = true;
					}
				}
				if(more){
					InstalacijaModulaView.getInstance().changeContentPane(new JezikPanel(module));
				}else{
					InstalacijaModulaView.getInstance().changeContentPane(new ProcesPanel(module));
				}
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints a = new GridBagConstraints();
		
		a.gridx = 0;
		a.gridy = 0;
		add(jezikLabel , a);
		c.insets = new Insets(10, 0, 10, 0);
		c.gridx = 0;
		c.gridy = 1;
		add(izaberiJezikCombo, c);
		a.gridx = 0;
		a.gridy = 2;
		add(jezikDugme, a);
		setSize(400, 150)
		;
		setMinimumSize(new Dimension(400, 150));
		}
	
	public void updateLanguage(){
		resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
		jezikLabel.setText(resourceBundle.getString("jezikLabel"));
		jezikDugme.setText(resourceBundle.getString("jezikDugme"));
	}
}
