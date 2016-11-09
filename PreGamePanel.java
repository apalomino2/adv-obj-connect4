import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PreGamePanel extends JPanel{
	private static final String A_PRESSED = "a pressed";
	private static final String A_RELEASED = "a released";
	private static final String L_PRESSED = "l pressed";
	private static final String L_RELEASED = "l released";
	private JLabel p1Msg, p2Msg;
	
	PreGamePanel(Connect4Controller ctrl) {
		setLayout(new GridBagLayout());
		setBackground(Color.BLACK);
		components(ctrl);
		inputMap(ctrl);
	}

	void components(Connect4Controller ctrl){
		GridBagConstraints c;

		JButton helpBtn = new JButton("?");
		helpBtn.addActionListener(ctrl);
		c = new GridBagConstraints();
		c.gridx  = 2;
		c.gridy  = 0;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.insets = new Insets(0, 0, 20, 0);
		add(helpBtn, c);

		JLabel c4Img = new JLabel("");
		c4Img.setIcon(new ImageIcon("icons/c4Img.jpg"));
		c = new GridBagConstraints();
		c.gridx      = 1;
		c.gridwidth  = 2;
		c.gridy      = 1;
		c.gridheight = 2;
		add(c4Img, c);

		p1Msg = new JLabel("Press a");
		c = new GridBagConstraints();
		c.gridx  = 1;
		c.gridy  = 3;
		c.insets = new Insets(20, 0, 0, 0);
		add(p1Msg, c);
		
		p2Msg = new JLabel("Press l");
		c = new GridBagConstraints();
		c.gridx  = 2;
		c.gridy  = 3;
		c.insets = new Insets(20, 0, 0, 0);
		add(p2Msg, c);
		
		JButton p1Btn = new JButton("Player1");
		p1Btn.addActionListener(ctrl);
		c = new GridBagConstraints();
		c.gridx  = 1;
		c.ipadx  = 80;
		c.gridy  = 4;
		c.ipady  = 40;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_START;
		add(p1Btn, c);

		JButton p2Btn = new JButton("Player2");
		p2Btn.addActionListener(ctrl);
		c.gridx  = 2;
		c.gridy  = 4;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		add(p2Btn, c);

	}
	
	void inputMap(Connect4Controller ctrl){
		InputMap  inputMap  = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = getActionMap();
		KeyStroke aPressed  = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false);
		KeyStroke aReleased = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true);
		KeyStroke lPressed  = KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false);
		KeyStroke lReleased = KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, true);
				
		inputMap.put(aPressed, A_PRESSED);
		inputMap.put(aReleased, A_RELEASED);
		inputMap.put(lPressed, L_PRESSED);
		inputMap.put(lReleased, L_RELEASED);
		
		actionMap.put(A_PRESSED,  new KeyAction(ctrl, "aPressed"));
		actionMap.put(A_RELEASED, new KeyAction(ctrl, "aReleased"));
		actionMap.put(L_PRESSED,  new KeyAction(ctrl, "lPressed"));
		actionMap.put(L_RELEASED, new KeyAction(ctrl, "lReleased"));
	}
	
	void setp1Msg(String s){
		p1Msg.setText(s);
	}
	
	void setp2Msg(String s){
		p2Msg.setText(s);
	}
}
