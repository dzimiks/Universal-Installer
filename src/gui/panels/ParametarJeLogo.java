package gui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.model.Parameter;

public class ParametarJeLogo extends JPanel {

	private JTextField tf;
	private JButton btnSearch;
	private File f;
	public ParametarJeLogo(Parameter p){
		
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(300, 30));
		
		btnSearch = new JButton("...");
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
				
		tf.setEditable(false);
		if(p.getF() != null){
			tf.setText(p.getF().toPath().toString());
		}
		
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		jfc.setFileFilter(filter);

		//TODO dodati u action menager
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jfc.showDialog(new JDialog(), "Choose") == JFileChooser.APPROVE_OPTION){
					tf.setText(jfc.getSelectedFile().getAbsolutePath());
					f = jfc.getSelectedFile();
					//TODO dodati fajl
				}				
			}
		});				

		add(new JLabel("Path: "));
		add(tf);
		add(btnSearch);
	}

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}
	
	
	
	
}
