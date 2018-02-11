package gui.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import gui.model.CopyParameter;

public class TocPanel extends JPanel{
	
	public TocPanel(CopyParameter parameter) throws IOException {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);
		
		setLayout(gridBagLayout);
		
		
		JTextArea tocArea = new JTextArea();
				
		BufferedReader bufferedReader = new BufferedReader(new FileReader(parameter.getValue()));
		String everything;
		try {
			
		    StringBuilder stringBuilder = new StringBuilder();
		    String line = bufferedReader.readLine();

		    while (line != null) {
		    	stringBuilder.append(line);
		    	stringBuilder.append(System.lineSeparator());
		        line = bufferedReader.readLine();
		    }
		    
		    everything = stringBuilder.toString();
		} finally {
			bufferedReader.close();
		}
		
		tocArea.setText(everything);
		tocArea.setLineWrap(true);
		tocArea.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(tocArea);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setMinimumSize(new Dimension(300,300));
		tocArea.setEditable(false);
		//tocArea.setPreferredSize(new Dimension(300,300));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(scroll, gbc);
		
		ButtonGroup radioGroup = new ButtonGroup();
		
		gbc.gridy = 1;
		JRadioButton yesRadio = new JRadioButton(resourceBundle.getString("yesRadio"));
		this.add(yesRadio, gbc);
		
		gbc.gridy = 2;
		JRadioButton noRadio = new JRadioButton(resourceBundle.getString("noRadio"));
		this.add(noRadio,gbc);
		
		noRadio.setSelected(true);
		
		radioGroup.add(yesRadio); radioGroup.add(noRadio);
		
		yesRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((ProcesPanel)InstalacijaModulaView.getInstance().getContentPane()).getDaljeButton().setEnabled(true);
				
			}
		});
		
		noRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((ProcesPanel)InstalacijaModulaView.getInstance().getContentPane()).getDaljeButton().setEnabled(false);
				
			}
		});
		
	}
}
