package gui.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.model.CopyModule;
import gui.model.CopySoftware;

public class IzaberiModulePanel extends JPanel{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	
	static int j = 0;
	
	ArrayList<CopyModule> listaModula = new ArrayList<>();
	ArrayList<JCheckBox> listaCheckBoxova = new ArrayList<>();
			
	public static int i = 0;
	
	public IzaberiModulePanel(CopySoftware copySoftware) {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gBagConstraints = new GridBagConstraints();
		
		gBagConstraints.insets = new Insets(10, 10, 10, 10);
		j = 0;
		i = 0;
		
		setLayout(gridBagLayout);
		
		JLabel izaberiModuleLabel = new JLabel(resourceBundle.getString("izaberiModuleLabel"));
		
		gBagConstraints.gridx= 0;
		gBagConstraints.gridy = 0;
		add(izaberiModuleLabel , gBagConstraints);
		
		//add(izaberiModuleLabel);
		
		
		
		for(CopyModule copyModule : copySoftware.getModules()){
			listaModula.add(copyModule);
			System.out.println(i);
			listaCheckBoxova.add(new JCheckBox(copyModule.getName()));
			//add(listaCheckBoxova.get(i));
			i++;
			//add(new JCheckBox(listaModula.get(i)));
		}
		
		int count = 0;
		gBagConstraints.gridx = 0;

		for(JCheckBox checkBox: listaCheckBoxova){
			count++;
			gBagConstraints.gridy = count;
			this.add(checkBox,gBagConstraints);
		}
		
		
		JButton daljeButton = new JButton(resourceBundle.getString("daljeButton"));
		
		daljeButton.setMinimumSize(new Dimension(70,45));

		
		gBagConstraints.gridx = 0;
		gBagConstraints.gridy = count + 1;
		
		this.add(daljeButton,gBagConstraints);
	
		daljeButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
				for(JCheckBox checkBox : listaCheckBoxova){
					if(checkBox.isSelected()){
						ok = true;
					}
				}
				if(ok){
					for(JCheckBox checkBox : listaCheckBoxova){
						if(!checkBox.isSelected()){
							listaModula.remove(j);
							j--;
						}
						j++;
					}
					KorisnikView.getInstance().changeContentPane(new SpisakModulaPanel(listaModula));
				}else{
					JFrame otvori = new ValidacijaModulaFrame();
					otvori.setVisible(true);
				}
			}
		});
	}
}
