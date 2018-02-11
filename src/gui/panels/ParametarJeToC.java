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

public class ParametarJeToC extends JPanel {

	private JTextField tf;
	private JButton btnSearch;
	private File f;

	public ParametarJeToC(Parameter p) {

		tf = new JTextField();
		if(p.getF() != null){
			tf.setText(p.getF().toPath().toString());
		}
		btnSearch = new JButton("Search");

		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		tf.setEditable(false);
		tf.setPreferredSize(new Dimension(300, 30));

		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "pdf");
		jfc.setFileFilter(filter);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfc.showOpenDialog(new JDialog()) == JFileChooser.APPROVE_OPTION) {
					tf.setText(jfc.getSelectedFile().getAbsolutePath());
					f = jfc.getSelectedFile();
					/// TODO dodati fajl

				}

			}
		});

		add(new JLabel("Path: "));
		add(tf);
		add(btnSearch);
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
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

}
