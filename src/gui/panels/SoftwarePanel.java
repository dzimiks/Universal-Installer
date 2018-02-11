package gui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gui.json.ReadJsonFile;
import gui.json.WriteJsonFile;
import gui.model.CopySoftware;
import gui.model.MainModel;
import gui.model.Module;
import gui.model.Parameter;
import gui.model.Software;
import gui.model.tree.Node;
import gui.user.KorisnikView;
import gui.view.MainView;

/*
 * Softver panel iz kojeg se pokrece preview deo
 * */

@SuppressWarnings("unused")
public class SoftwarePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Komponente
	
	private static JButton tryNowbtn;
	private static JButton chooseFilebtn;
	private JTextField jtf;
	private MainModel model;
	private JTextField chosenFileTf;
	private JFileChooser fileChooser;
	private FileNameExtensionFilter filter;
	
	// Aktivni softver
	private Software activeSoftware;
	private File readFromFile;
	private CopySoftware copySoftware;

	
	public SoftwarePanel(MainModel model, Software sw) {
		super();
		this.model = model;
		
		initSoftwarePanel();
		
		chooseFilebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(fileChooser.showDialog(new JDialog(), "Choose") == fileChooser.APPROVE_OPTION){
					jtf.setText(fileChooser.getSelectedFile().getAbsolutePath());	
					chosenFileTf.setText(fileChooser.getSelectedFile().getAbsolutePath());
//					System.out.println(chosenFileTf.getText());
					readFromFile =  fileChooser.getSelectedFile();
				}	
			}
		});
		
		
		activeSoftware = sw;
		
		// Akcija za try now dugme
		tryNowbtn.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {				
				// Validacija
				String[] path = null;
				String validPath = null;
			
				if (getChosenFile() == null || getChosenFile().equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas, unesite putanju do projekta.", 
							model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
					return;
				}

			/*	path = getChosenFile().split(File.separator);
				validPath = path[path.length - 2];
				
				if (!validPath.equals("Resources") || validPath == null || validPath.equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas, unesite validnu putanju do projekta.", 
							model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
					return;
				}*/
				
				try {
					 copySoftware = ReadJsonFile.readJsonFile(readFromFile);
					
				} catch (JsonParseException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// Pokretanje korisnickog dela
				KorisnikView korisnikView = KorisnikView.getInstance();
				korisnikView.setVisible(true);
				MainView.getInstance().setEnabled(false);
			}
		});
		
	}
	
	public void initSoftwarePanel(){
		JPanel donjiPanel = new JPanel();
		JPanel centralniPanel = new JPanel();
		
		BorderLayout borderLayout = new BorderLayout(10,10);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT,10,10);
		FlowLayout fileFlowLayout = new FlowLayout(FlowLayout.CENTER,10,10);
		
		
		chosenFileTf = new JTextField();
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Json libraries", "json");
		fileChooser.setFileFilter(filter);
		
		chooseFilebtn = new JButton("Choose");
		tryNowbtn = new JButton("Try now");
		
		tryNowbtn.setPreferredSize(new Dimension(150,50));
		chooseFilebtn.setPreferredSize(new Dimension(75,30));
		
		jtf = new JTextField();
		jtf.setPreferredSize(new Dimension(300,40));
		jtf.setEditable(false);
				
		centralniPanel.setLayout(fileFlowLayout);
		donjiPanel.setLayout(flowLayout);
		
		this.setLayout(borderLayout);
		
		centralniPanel.add(jtf); 
		centralniPanel.add(chooseFilebtn);
		
		donjiPanel.add(tryNowbtn);
		
		this.add(donjiPanel, BorderLayout.SOUTH);
		this.add(centralniPanel,BorderLayout.CENTER);
	}


	public String getChosenFile() {
		return chosenFileTf.getText();
	}

	public CopySoftware getCopySoftware() {
		return copySoftware;
	}
}
