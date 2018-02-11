package gui.user;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.model.CopyModule;
import gui.model.CopyParameter;

public class ShortcutAndStartPanel extends JPanel{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	
	private static int naziv2 = 0;
	
	GridBagLayout gridBagLayout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JButton finishButton;
	
	private boolean hasShortcut , hasStart;
	
	public ShortcutAndStartPanel(CopyModule module , String lokacija) {
		
		setLayout(gridBagLayout);
		
		JLabel lb = new JLabel(resourceBundle.getString("lb"));
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lb , gbc);		
		JCheckBox cb = new JCheckBox();
		
		JCheckBox cb2 = new JCheckBox();
		
		hasShortcut = false;
		for(CopyParameter parameter : module.getParameters()){
			if(parameter.getType().equals(gui.model.Type.DESKTOP_SHORTCUT)){
				if(parameter.getValue().equals("true")){
					cb.setText(resourceBundle.getString("shortcutCb"));
					hasShortcut = true;
				}
			}
		}
		if(hasShortcut){
			gbc.gridy = 1;
			this.add(cb,gbc);
		}
		hasStart = false;
		for(CopyParameter parameter : module.getParameters()){
			if(parameter.getType().equals(gui.model.Type.START)){
				if(parameter.getValue().equals("true")){
					hasStart = true;
					cb2.setText(resourceBundle.getString("startCb"));
				}
			}
		}
		
		if(hasShortcut && hasStart){
			gbc.gridy= 2;
			this.add(cb2 , gbc);
		}else if(hasStart){
			gbc.gridy = 1;
			this.add(cb2 , gbc);
		}
		
		finishButton= new JButton("Finish");
		if(hasShortcut && hasStart){
			gbc.gridy = 3;
			this.add(finishButton , gbc);
		}else if(hasShortcut || hasStart){
			gbc.gridy = 2;
			this.add(finishButton , gbc);
		}else{
			gbc.gridy = 1;
			this.add(finishButton , gbc);
		}
		
		
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(hasShortcut && cb.isSelected()){
					String[] s = module.getLockPath().split("\\.");
					String str = javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toString() +
							File.separator + module.getName() + String.valueOf(naziv2) + "." + s[1];
					naziv2++;
					File sourceFile = new File(lokacija);
					File destinationFile = new File(str);
					Path sourcePath = sourceFile.toPath();
					Path destinationPath = destinationFile.toPath();
					try {
						Files.copy(sourcePath, destinationPath);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				if(hasStart && cb2.isSelected()){
					try {
						Desktop.getDesktop().open(new File(lokacija));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				InstalacijaModulaView.getInstance().dispose();
				KorisnikView.getInstance().setEnabled(true);
				KorisnikView.getInstance().toFront();
				
			}
		});
		
		
	}
/**	public ShortcutAndStartPanel(CopyParameter p) {
		setLayout(gridBagLayout);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel lb = new JLabel(resourceBundle.getString("lb"));
		this.add(lb, gbc);
		
		JLabel lb2 = new JLabel(resourceBundle.getString("lb2"));
		gbc.gridx = 1;
		this.add(lb2, gbc);
		
		JCheckBox cb = new JCheckBox();
		if(p.getValue().equals("create desktop shortcut")){
			cb.setText(resourceBundle.getString("shortcutCb"));
		}
		else if(p.getValue().equals("start program")){
			cb.setText(resourceBundle.getString("startCb"));
		}
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(cb, gbc);
	}
	public ShortcutAndStartPanel(CopyParameter p1 , CopyParameter p2) {
		setLayout(gridBagLayout);
		gbc.insets = new Insets(10, 5, 10, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lb = new JLabel(resourceBundle.getString("lb"));
		this.add(lb, gbc);
	
		gbc.gridx = 1;

		JLabel lb2 = new JLabel(resourceBundle.getString("lb2"));
		this.add(lb2, gbc);
		
		JCheckBox cb = new JCheckBox();
		if(p1.getValue().equals("create desktop shortcut"));
		{
			cb.setText(resourceBundle.getString("shortcutCb"));
		}
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(cb, gbc);
		
		JCheckBox cb2 = new JCheckBox();
		if(p2.getValue().equals("start program"))
		{
			//TODO Ne radi iz nekog razloga
			// Ne prikazuje ime cb2
			cb2.setText(resourceBundle.getString("startCb"));
		}
		
		gbc.gridx = 1;
		this.add(cb2,gbc);
	}			**/
}
