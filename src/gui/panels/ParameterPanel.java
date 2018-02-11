package gui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;


import gui.commands.Invoker;
import gui.commands.TreeSelectCommand;
import gui.model.LookModel;
import gui.model.MainModel;
import gui.model.Module;
import gui.model.Parameter;
import gui.model.Software;
import gui.panels.custom.CustomPanelJSONModel;
import gui.panels.custom.GlavniPanel;
import gui.panels.custom.GlavniPanelToString;
import gui.view.MainView;

public class ParameterPanel extends JPanel {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1L;

	private JTextField tfName;
	private JTextField tfType;
	private JTextField tfValue;
	private JTextField tfPath;
	private Parameter activeParameter;
	private MainModel model;
	private JPanel panel;
	private NazivParametra nazivPanel;
	private TipParametra tipPanel;
	private static int revision = 0;

	public ParameterPanel(Parameter p, MainModel model) {
		super();
		activeParameter = p;
		this.model = model;
		// Opis panela
		setLayout(new BorderLayout());

		nazivPanel = new NazivParametra(activeParameter);
		JPanel dugmici = dugmici();
		tipPanel = new TipParametra(activeParameter);

		switch (activeParameter.getType()) {
		case NAME:
			panel = new ParametarJeName(activeParameter);
			break;
		case AUTHOR:
			panel = new ParametarJeAuthor(activeParameter);
			break;
		case DESCRIPTION:
			panel = new ParametarJeOpis(activeParameter);
			break;
		case LOGO:
			panel = new ParametarJeLogo(activeParameter);
			break;
		case VERSION:
			panel = new ParametarJeVerzija(activeParameter);
			break;
		case TOC:
			panel = new ParametarJeToC(activeParameter);
			break;
		case LOOKNFEEL:
			panel = new ParametarJeLookNFeel(activeParameter);
			break;
		case LANGUAGE:
			panel = new ParametarJeLanguage(activeParameter);
			break;
		case DESKTOP_SHORTCUT:
			panel = new ParametarJeDesktop(activeParameter);
			break;
		case START:
			panel = new ParametarJeStart(activeParameter);
			break;
		case CUSTOM:
			panel = new ParametarJeProizvoljan(activeParameter);
			((GlavniPanel) ((ParametarJeProizvoljan) panel).getJp()).vidiljiviDugmici();
		}

		JPanel mid = new JPanel();
		mid.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		mid.add(nazivPanel, c);
		c.gridx = 0;
		c.gridy = 1;
		mid.add(tipPanel, c);
		c.gridx = 0;
		c.gridy = 2;
		mid.add(panel, c);
		add(mid, BorderLayout.CENTER);

		// add(tipPanel, BorderLayout.CENTER);
		// add(panel, BorderLayout.CENTER);
		add(dugmici, BorderLayout.SOUTH);
	}

	/**
	 * 
	 * Sredjuje stalni panel za gumice Save, Cancel, Help
	 * 
	 * @return sredjeni panel dugmica
	 */
	private JPanel dugmici() {
		JPanel dugmici = new JPanel();

		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 50, 50);

		dugmici.setLayout(fl);

		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");
		JButton btnHelp = new JButton("Help");

		// Akcija za Save
		/// TODO ubaciti u actionMenager
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				activeParameter.setName(nazivPanel.getTf().getText());

				if (panel instanceof ParametarJeAuthor) {

					ParametarJeAuthor p = (ParametarJeAuthor) panel;
					activeParameter.setValue(p.getTf().getText());

				} else if (panel instanceof ParametarJeName) {

					ParametarJeName p = (ParametarJeName) panel;
					activeParameter.setValue(p.getTf().getText());

				} else if (panel instanceof ParametarJeVerzija) {

					ParametarJeVerzija p = (ParametarJeVerzija) panel;
					activeParameter.setValue(p.getTf().getText());

				} else if (panel instanceof ParametarJeOpis) {

					ParametarJeOpis p = (ParametarJeOpis) panel;
					File sourceFile = p.getF();
					copyFile(sourceFile);


				} else if (panel instanceof ParametarJeToC) {

					ParametarJeToC p = (ParametarJeToC) panel;
					File sourceFile = p.getF();
					copyFile(sourceFile);

				} else if (panel instanceof ParametarJeStart) {

					ParametarJeStart p = (ParametarJeStart) panel;
					activeParameter.setValue(String.valueOf(p.getCb().isSelected()));

				} else if (panel instanceof ParametarJeDesktop) {

					ParametarJeDesktop p = (ParametarJeDesktop) panel;
					activeParameter.setValue(String.valueOf(p.getCb().isSelected()));

				} else if (panel instanceof ParametarJeLanguage) {
					
					ParametarJeLanguage p = (ParametarJeLanguage) panel;

					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(p.getCb1().isSelected()));
					sb.append("-");
					sb.append(String.valueOf(p.getCb2().isSelected()));		
					sb.append("-");
					sb.append(String.valueOf(p.getCb3().isSelected()));
					
					activeParameter.setValue(sb.toString());


				} else if (panel instanceof ParametarJeLogo) {

					ParametarJeLogo p = (ParametarJeLogo) panel;
					File sourceFile = p.getF();
					copyFile(sourceFile);

				} else if (panel instanceof ParametarJeLookNFeel) {
					
					ParametarJeLookNFeel p = (ParametarJeLookNFeel) panel;
					activeParameter.setValue(((LookModel)p.getCb().getSelectedItem()).getVrednsot());
					
				} else if (panel instanceof ParametarJeProizvoljan) {
					
					((GlavniPanel) ((ParametarJeProizvoljan) panel).getJp()).nevidljiviDugmici();

					ParametarJeProizvoljan p = (ParametarJeProizvoljan) panel;
					GlavniPanelToString gp = new GlavniPanelToString(p.getJp());
					activeParameter.setValue(gp.toString());

				}

				model.getTreeModel().reload();
				Invoker.getInstance().executeCommand(new TreeSelectCommand(model, activeParameter));
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainView.getInstance().getSplitPane().remove(MainView.getInstance().getPanRight());
			}
		});

		dugmici.add(btnSave);
		dugmici.add(btnCancel);
		return dugmici;
	}

	private void copyFile(File a) {
		if (a == null)
			return;
		String s = a.getPath().toString();
		String root = "Resources/" + ((Software) activeParameter.getParent().getParent()).getName() + "/" +  ((Module)activeParameter.getParent()).getName();
		String fileName = activeParameter.getName() + String.valueOf(this.revision++) + "." + s.charAt(s.length() - 3) + s.charAt(s.length() - 2) + s.charAt(s.length() - 1);
		
		File destinationFile = new File(root, fileName);
		activeParameter.setF(a);
		activeParameter.setValue(destinationFile.getPath().toString());
		Path sourcePath = a.toPath();
		Path destinationPath = destinationFile.toPath();
		try {
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public JTextField getTfType() {
		return tfType;
	}

	public JTextField getTfValue() {
		return tfValue;
	}

	public JTextField getTfPath() {
		return tfPath;
	}

}
