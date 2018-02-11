package gui.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathPanel extends JPanel{
	
	private File fajl;
	private JTextField textField;
	JFileChooser jfc;
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());

	public PathPanel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbConstrains = new GridBagConstraints();
		
		setLayout(gridBagLayout);
		
		JLabel izaberiLabel = new JLabel(resourceBundle.getString("izaberiLabel"));
		
		JButton browseButton = new JButton(resourceBundle.getString("browseButton"));
		browseButton.setMinimumSize(new Dimension(70, 45));
		
		jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		textField = new JTextField(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString());
		textField.setEditable(false);
		textField.setPreferredSize(new Dimension(200,35));
		
		
		gbConstrains.insets = new Insets(20, 10, 20, 10);

		gbConstrains.gridx = 0;
		gbConstrains.gridy = 0;
		add(izaberiLabel,gbConstrains);
		
		gbConstrains.gridx = 0;
		gbConstrains.gridy = 3;		
		add(textField, gbConstrains);
		
		gbConstrains.gridx = 1;
		gbConstrains.gridy = 3;
		add(browseButton, gbConstrains);
		
		
		browseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jfc.showOpenDialog(new JDialog()) == JFileChooser.APPROVE_OPTION) {
					textField.setText(jfc.getSelectedFile().getAbsolutePath());
					fajl = jfc.getSelectedFile();
				}
				
			}
		});
		
	}
	public String getFile() {
		return textField.getText();
	}
}
