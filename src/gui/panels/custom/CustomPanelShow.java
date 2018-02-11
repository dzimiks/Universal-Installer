package gui.panels.custom;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomPanelShow extends JPanel {

	public CustomPanelShow(String string) {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		String[] podeljenNaPanele = string.split("-");
		for (String s : podeljenNaPanele) {
			String[] vau = s.split("~");
			if (vau.length == 1) {
				if (vau[0].equals("CHECKBOX")) {
					JCheckBox jcb = new JCheckBox();
					jcb.setPreferredSize(new Dimension(200, 30));
					add(jcb);
				} else if (vau[0].equals("LABEL")) {
					JLabel jlb = new JLabel();
					jlb.setPreferredSize(new Dimension(200, 30));
					add(jlb);
				} else if (vau[0].equals("TEXTFIELD")) {
					JTextField jtf = new JTextField();
					jtf.setPreferredSize(new Dimension(200, 30));
					add(jtf);
				}
			} else {
				if (vau[0].equals("CHECKBOX")) {
					JCheckBox jcb = new JCheckBox(vau[1]);
					jcb.setPreferredSize(new Dimension(200, 30));
					add(jcb);
				} else if (vau[0].equals("LABEL")) {
					JLabel jlb = new JLabel(vau[1]);
					jlb.setPreferredSize(new Dimension(200, 30));
					add(jlb);
				} else if (vau[0].equals("TEXTFIELD")) {
					JTextField jtf = new JTextField(vau[1]);
					jtf.setPreferredSize(new Dimension(200, 30));
					add(jtf);
				}
			}
		}
	}

}
