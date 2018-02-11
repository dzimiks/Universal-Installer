package gui.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.org.apache.bcel.internal.Constants;

import gui.Main;
import gui.model.LookModel;
import gui.model.Parameter;
import gui.view.MainView;

public class ParametarJeLookNFeel extends JPanel{
	
	private JComboBox<LookModel> cb;
	private JLabel slika;
	public ParametarJeLookNFeel(Parameter p){
			
		cb = new JComboBox();
		cb.setMaximumSize(new Dimension(400, 30));
		cb.setMinimumSize(new Dimension(400, 30));
		cb.setPreferredSize(new Dimension(400, 30));
		slika = new JLabel();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 5, 10, 5);
		c.gridx = 0;
		c.gridy = 0;
		
		LookModel lookModel_01 = new LookModel("Metal","javax.swing.plaf.metal.MetalLookAndFeel", gui.constants.Constants.METAL);
		LookModel lookModel_02 = new LookModel("Liquid","com.birosoft.liquid.LiquidLookAndFeel", gui.constants.Constants.LIQUID);
		LookModel lookModel_03 = new LookModel("Texture","com.jtattoo.plaf.texture.TextureLookAndFeel", gui.constants.Constants.TEXTURE);
		LookModel lookModel_04 = new LookModel("Acryl","com.jtattoo.plaf.acryl.AcrylLookAndFeel", gui.constants.Constants.ACRYL);
		LookModel lookModel_05 = new LookModel("Aluminium","com.jtattoo.plaf.aluminium.AluminiumLookAndFeel", gui.constants.Constants.ALUMINIUM);
		LookModel lookModel_06 = new LookModel("Bernstein","com.jtattoo.plaf.bernstein.BernsteinLookAndFeel", gui.constants.Constants.BERNSTEIN);
		
		cb.addItem(lookModel_01);
		cb.addItem(lookModel_02);
		cb.addItem(lookModel_03);
		cb.addItem(lookModel_04);
		cb.addItem(lookModel_05);
		cb.addItem(lookModel_06);	
		
		if(p.getValue() != null){
			if(lookModel_01.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_01);
			}else if(lookModel_02.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_02);
			}else if(lookModel_03.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_03);
			}else if(lookModel_04.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_04);
			}else if(lookModel_05.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_05);
			}else if(lookModel_06.getVrednsot().equals(p.getValue())){
				cb.setSelectedItem(lookModel_06);
			}
		}
		
		BufferedImage pre;
		try {
			pre = ImageIO.read(new File(((LookModel)cb.getSelectedItem()).getPath()));
			slika = new JLabel(new ImageIcon(pre));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		add(cb, c);
		
		c.gridy = 1;
		
		add(slika, c);
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					remove(slika);
					BufferedImage pre = ImageIO.read(new File(((LookModel)cb.getSelectedItem()).getPath()));
					//slika = new JLabel(((LookModel)cb.getSelectedItem()).getPath());
					slika = new JLabel(new ImageIcon(pre));
					add(slika, c);
					
					JPanel jp = MainView.getInstance().getPanRight();
					MainView.getInstance().getSplitPane().remove(jp);
					MainView.getInstance().getSplitPane().add(jp);
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
	}
	public JComboBox<LookModel> getCb() {
		return cb;
	}
	public void setCb(JComboBox<LookModel> cb) {
		this.cb = cb;
	}
	
	
}
