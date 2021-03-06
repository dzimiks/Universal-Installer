package gui.view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.model.Student;

public class StudentPanel extends JPanel {
	
	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	public StudentPanel(Student student) {
		JPanel info = new JPanel();
		
		BoxLayout boxParent = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(boxParent);
		
		BoxLayout box = new BoxLayout(info, BoxLayout.Y_AXIS);
		info.setLayout(box);
		
		// Ucitavanje slike
		BufferedImage pre;
		try {
			pre = ImageIO.read(new File(student.getPath()));
			JLabel picLabel = new JLabel(new ImageIcon(pre));
			
			add(picLabel);
		} catch (IOException e) {
			JLabel slika = new JLabel("Sliku nije moguće prikazati");
			add(slika);
			e.printStackTrace();
		}
		
		// Informacije o studentu
		JLabel ime = new JLabel(student.getIme() + " " + student.getPrezime());
		JLabel indeks = new JLabel(student.getIndeks());
		
		info.add(ime);
		info.add(indeks);
		
		add(Box.createRigidArea(new Dimension(50, 0)));
		add(info);
	}
}
