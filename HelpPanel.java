 import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel {
	HelpPanel(Connect4Controller ctrl){
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK);
		GridBagConstraints c;
		
		JLabel firstLabel = new JLabel("");
		firstLabel.setIcon(new ImageIcon("icons/Connect_4_Instructions.jpg"));
		c = new GridBagConstraints();
		c.gridx      = 1;
		c.gridwidth  = 2;
		c.gridy      = 1;
		c.gridheight = 2;
		c.anchor     = GridBagConstraints.CENTER;
		add(firstLabel, c);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(ctrl);
		c = new GridBagConstraints();
		c.gridx  = 1;
		c.ipadx  = 100;
		c.gridy  = 3;
		c.ipady  = 40;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_START;
		add(backBtn, c);
	}
}
