package gui.user;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import gui.model.CopyParameter;

public class DescriptionPanel extends JPanel{
	
	public DescriptionPanel(CopyParameter parameter) throws IOException {
		//aaa
		System.out.println("Pozivam Description panel");
		
		JTextArea textArea = new JTextArea();
		//textArea.setPreferredSize(new Dimension(300,300));

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(300,300));
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);

		
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
		
		textArea.setText(everything);

		add(scroll);
	}
}
