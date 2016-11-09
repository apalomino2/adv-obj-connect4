import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	StartPanel(Connect4Controller controller){
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK);
		GridBagConstraints c;
		
		JLabel firstLabel = new JLabel("");
		firstLabel.setIcon(new ImageIcon("icons/c4Img.jpg"));
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.CENTER;
		add(firstLabel, c);
		
		JButton playBtn = new JButton("Play");
		playBtn.addActionListener(controller);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.ipadx = 100;
		c.gridy = 3;
		c.ipady = 40;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_START;
		add(playBtn, c);
		
		JButton instructionsBtn = new JButton("Instructions");
		instructionsBtn.addActionListener(controller);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.ipadx = 50;
		c.gridy = 3;
		c.ipady = 40;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		add(instructionsBtn, c);
	}
}
