package gui.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import gui.constants.Constants;

import gui.model.*;
import gui.panels.ParameterPanel;
import gui.panels.SoftwarePanel;
import gui.view.tree.TreeView;

public class MainView extends JFrame {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private static MainView instance;

	private JPanel panRight;
	private JPanel panLeft;
	private MenuBarView menuBar;
	private ToolBarView toolBar;
	private TreeView treeView;
	private JSplitPane splitPane;

	private MainModel model;
	private SoftwarePanel softverPanel;

	
	private MainView() {
		
	}

	private void initialize() {

		// Podesavanje MainView-a

		setLookAndFeel();
		this.model = MainModel.getInstance();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setLayout(new BorderLayout());
		setSize(Constants.WINDOW_SIZE);
		setMinimumSize(new Dimension(screenWidth / 2, screenHeight - 200));
		//setTitle("TensorFlow - Univerzalni Instalator");
		setTitle("Universal Installer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Ikonica
		try {
			this.setIconImage(ImageIO.read(new File(Constants.UI_ICON)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Dodavanje komponenti

		// MenuBar
		menuBar = new MenuBarView(this.model);
		this.setJMenuBar(menuBar);

		// ToolBar
		toolBar = new ToolBarView(this.model);
		this.add(toolBar, BorderLayout.PAGE_START);

		panRight = new JPanel();
		
		splitPane = new JSplitPane();
		splitPane.setLayout(new BorderLayout());
		splitPane.add(panRight);
		
		// TODO sredi ovo 
		// Leva strana MainFrame-a ili treeView
		treeView = new TreeView(this.model);

		treeView.getTree().addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				Object node = e.getPath().getLastPathComponent();
				if(node == null) {
					return;
				}
				splitPane.remove(panRight);
				if (node instanceof Parameter) {
		
					panRight = new ParameterPanel((Parameter)node, model);
					splitPane.add(panRight);
					disableForParametar();
					
				}
				if(node instanceof Module) {
					splitPane.add(panRight = new JPanel());
					disableForModule();
				}
				if(node instanceof Software) {

					panRight = new SoftwarePanel(model, (Software)node);
					splitPane.add(panRight);

					disableForSoftware();
				}
				if(node instanceof Workspace) {
					splitPane.add(panRight = new JPanel());
					disableForWorkspace();
				}
			}
		});

		this.add(treeView, BorderLayout.LINE_START);
		this.add(splitPane, BorderLayout.CENTER);
	}
	
	/**
	 * Onemogucava ikonice ukoliko je Parametar seletovan
	 */
	private void disableForParametar(){
		menuBar.getMenu(0).getItem(0).setEnabled(false);
		menuBar.getMenu(0).getItem(1).setEnabled(false);
		menuBar.getMenu(0).getItem(3).setEnabled(false);
		menuBar.getMenu(0).getItem(5).setEnabled(false);
		toolBar.getComponent(0).setEnabled(false);
		toolBar.getComponent(1).setEnabled(false);
		toolBar.getComponent(2).setEnabled(false);
		toolBar.getComponent(7).setEnabled(false);
	}
	
	/**
	 * Onemogucava ikonice ukoliko je Modul selektovan
	 */
	private void disableForModule(){
		menuBar.getMenu(0).getItem(0).setEnabled(false);
		menuBar.getMenu(0).getItem(1).setEnabled(false);
		menuBar.getMenu(0).getItem(3).setEnabled(true);
		menuBar.getMenu(0).getItem(5).setEnabled(false);
		toolBar.getComponent(0).setEnabled(false);
		toolBar.getComponent(1).setEnabled(false);
		toolBar.getComponent(2).setEnabled(true);
		toolBar.getComponent(7).setEnabled(false);
	}

	/**
	 * Onemogucacva ikonice ukoliko je Workspace selektovan
	 */
	private void disableForWorkspace(){
		menuBar.getMenu(0).getItem(0).setEnabled(true);
		menuBar.getMenu(0).getItem(1).setEnabled(false);
		menuBar.getMenu(0).getItem(3).setEnabled(false);
		menuBar.getMenu(0).getItem(5).setEnabled(false);
		toolBar.getComponent(0).setEnabled(true);
		toolBar.getComponent(1).setEnabled(false);
		toolBar.getComponent(2).setEnabled(false);
		toolBar.getComponent(7).setEnabled(false);
	}
	
	/**
	 * Onemogucava ikonice ukoliko je Software selektovan
	 */
	private void disableForSoftware(){
		menuBar.getMenu(0).getItem(0).setEnabled(false);
		menuBar.getMenu(0).getItem(1).setEnabled(true);
		menuBar.getMenu(0).getItem(3).setEnabled(false);
		menuBar.getMenu(0).getItem(5).setEnabled(true);
		toolBar.getComponent(0).setEnabled(false);
		toolBar.getComponent(1).setEnabled(true);
		toolBar.getComponent(2).setEnabled(false);
		toolBar.getComponent(7).setEnabled(true);
	}
	
	private void setLookAndFeel() {

//		WebLookAndFeel.install();
		
		try {
			// JTattoo LaF
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getPanRight() {
		return panRight;
	}

	public JPanel getPanLeft() {
		return panLeft;
	}

	public ToolBarView getToolBar() {
		return toolBar;
	}

	public TreeView getTreeView() {
		return treeView;
	}
	
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public static MainView getInstance() {
		if (instance == null) {
			instance = new MainView();
			instance.initialize();
		}

		return instance;
	}

	public SoftwarePanel getSoftverPanel() {
		return softverPanel;
	}

	public void setSoftverPanel(SoftwarePanel softverPanel) {
		this.softverPanel = softverPanel;
	}
}