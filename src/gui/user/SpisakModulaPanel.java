package gui.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Main;
import gui.model.CopyModule;
import gui.view.MainView;

public class SpisakModulaPanel extends JPanel{
	
	private static int brojModula = -1;
	private int count = 0;
	private ArrayList<CopyModule> modules = new ArrayList<>();
	
	public SpisakModulaPanel(ArrayList<CopyModule> modulesList) {
		
		modules = modulesList;
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gBagConstraints = new GridBagConstraints();
		gBagConstraints.insets = new Insets(12, 5, 12, 5);
		
		brojModula = -1
				;
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
		
		setLayout(gridBagLayout);
		
		JLabel chosenModelsLabel = new JLabel(resourceBundle.getString("chosenModelsLabel"));
		gBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gBagConstraints.gridwidth = 2;
		gBagConstraints.gridx = 0;
		gBagConstraints.gridy = 0;
		this.add(chosenModelsLabel, gBagConstraints);
		
		for(CopyModule mod : modulesList){
			count++;
			gBagConstraints.gridy = count;
			JLabel lbl = new JLabel("*" + mod.getName());
			this.add(lbl, gBagConstraints);
		}
		
		gBagConstraints.gridy = count + 1;
		
		JButton pocniInstalacijuButton = new JButton(resourceBundle.getString("pocniInstalacijuButton"));
		this.add(pocniInstalacijuButton, gBagConstraints);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = count + 2;
		
		JButton cancelInstallation = new JButton(resourceBundle.getString("cancelInstallation"));
		this.add(cancelInstallation, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(15, 15, 15, 0);

		JButton finishButton = new JButton(resourceBundle.getString("finishButton"));
		this.add(finishButton,gbc);
		finishButton.setEnabled(false);
		
		cancelInstallation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				KorisnikView.getInstance().dispose();	
				MainView.getInstance().setEnabled(true);
				MainView.getInstance().toFront();
				
			}
		});
		
		pocniInstalacijuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				brojModula++;
				if((brojModula) == modulesList.size() - 1){
					pocniInstalacijuButton.setEnabled(false);
					finishButton.setEnabled(true);
				}
				
				InstalacijaModulaView.getInstance();
				InstalacijaModulaView.getInstance().setVisible(true);
			}
		});
		
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KorisnikView.getInstance().changeContentPane(new ProgresPanel(2));
			}
		});
	}
	
	public CopyModule getModule(){
		return modules.get(brojModula);
	}

}
