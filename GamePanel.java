import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class GamePanel extends JPanel{
	private JLabel[][] board;
	private JLabel     msgLbl;
	private JLabel 	   timeLbl;
	private JLabel     p1Score;
	private JLabel     p2Score;
	private JTextField p1Name;
	private JTextField p2Name;

	
	GamePanel(Connect4Controller ctrl){
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		components(ctrl);
		inputMap(ctrl);
	}
	
	void components(Connect4Controller ctrl){
		GridBagConstraints c;
		
		p1Name = new JTextField("Player1");
		p1Name.setBackground(Color.DARK_GRAY);
		p1Name.setForeground(Color.WHITE);
		c = new GridBagConstraints();
		c.gridx      = 0;
		c.gridwidth  = 2;
		c.gridy      = 0;
		c.gridheight = 2;
		c.anchor     = GridBagConstraints.CENTER;
		c.insets     = new Insets(0, 0, 0, 30);
		add(p1Name, c);
		p1Score = new JLabel("Score: 0");
		p1Score.setForeground(Color.WHITE);
		c.gridy = 2;
		add(p1Score, c);
		JLabel p1Color = new JLabel("");
		p1Color.setIcon(new ImageIcon("icons/red.jpg"));
		c.gridy = 4;
		add(p1Color, c);
		
		p2Name = new JTextField("Player2");
		p2Name.setBackground(Color.DARK_GRAY);
		p2Name.setForeground(Color.WHITE);
		c.gridx = 9;
		c.gridy = 0;
		c.insets = new Insets(0, 30, 0, 0);
		add(p2Name, c);
		p2Score = new JLabel("Score: 0");
		p2Score.setForeground(Color.WHITE);
		c.gridy = 2;
		add(p2Score, c);
		JLabel p2Color = new JLabel("");
		p2Color.setIcon(new ImageIcon("icons/blue.jpg"));
		c.gridy = 4;
		add(p2Color, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		board = new JLabel[7][6];
		for(int x=0; x<7; x++){
			for(int y=0; y<6; y++){
				c.gridx = 2+x;
				c.gridy = y;
				board[x][y] = new JLabel();
				board[x][y].setIcon(new ImageIcon("icons/blank.jpg"));
				add(board[x][y], c);
			}
			
			JButton btn = new JButton(""+ (x+1));
			btn.addActionListener(ctrl);
			c.gridy = 6;
			add(btn, c);
		}
		
		JButton resignBtn = new JButton("Resign");
		resignBtn.addActionListener(ctrl);
		c.gridy = 8;
		c.gridx = 2;
		add(resignBtn, c);
		JButton drawBtn = new JButton("Draw");
		drawBtn.addActionListener(ctrl);
		c.gridx = 4;
		add(drawBtn, c);
		JButton pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(ctrl);
		c.gridx = 6;
		add(pauseBtn, c);
		JButton helpBtn = new JButton("Help");
		pauseBtn.addActionListener(ctrl);
		c.gridx = 8;
		add(helpBtn, c);

		timeLbl = new JLabel("Time: 30");
		timeLbl.setFont(new Font("Times New Roman", 0, 20));
		timeLbl.setForeground(Color.WHITE);
		c.gridy = 7;
		c.gridwidth = 3;
		c.gridx = 5;
		c.anchor = GridBagConstraints.CENTER;
		add(timeLbl, c);
		msgLbl = new JLabel("Player1's turn");
		msgLbl.setForeground(Color.WHITE);
		c.gridx = 2;
		add(msgLbl, c);
	}
	
	void inputMap(Connect4Controller ctrl){
		InputMap  inputMap  = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = getActionMap();

		KeyStroke pressed1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false);
		KeyStroke pressed2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false);
		KeyStroke pressed3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false);
		KeyStroke pressed4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false);
		KeyStroke pressed5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false);
		KeyStroke pressed6 = KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false);
		KeyStroke pressed7 = KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false);
		KeyStroke released1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, true);
		KeyStroke released2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, true);
		KeyStroke released3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, true);
		KeyStroke released4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, true);
		KeyStroke released5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, true);
		KeyStroke released6 = KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, true);
		KeyStroke released7 = KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, true);
		
		inputMap.put(pressed1, "pressed1");
		inputMap.put(pressed2, "pressed2");		
		inputMap.put(pressed3, "pressed3");		
		inputMap.put(pressed4, "pressed4");		
		inputMap.put(pressed5, "pressed5");		
		inputMap.put(pressed6, "pressed6");		
		inputMap.put(pressed7, "pressed7");		
		inputMap.put(released1, "released1");
		inputMap.put(released2, "released2");		
		inputMap.put(released3, "released3");		
		inputMap.put(released4, "released4");		
		inputMap.put(released5, "released5");		
		inputMap.put(released6, "released6");		
		inputMap.put(released7, "released7");		

		actionMap.put("pressed1",  new KeyAction(ctrl, "pressed1"));
		actionMap.put("pressed2",  new KeyAction(ctrl, "pressed2"));
		actionMap.put("pressed3",  new KeyAction(ctrl, "pressed3"));
		actionMap.put("pressed4",  new KeyAction(ctrl, "pressed4"));
		actionMap.put("pressed5",  new KeyAction(ctrl, "pressed5"));
		actionMap.put("pressed6",  new KeyAction(ctrl, "pressed6"));
		actionMap.put("pressed7",  new KeyAction(ctrl, "pressed7"));
		actionMap.put("released1",  new KeyAction(ctrl, "released1"));
		actionMap.put("released2",  new KeyAction(ctrl, "released2"));
		actionMap.put("released3",  new KeyAction(ctrl, "released3"));
		actionMap.put("released4",  new KeyAction(ctrl, "released4"));
		actionMap.put("released5",  new KeyAction(ctrl, "released5"));
		actionMap.put("released6",  new KeyAction(ctrl, "released6"));
		actionMap.put("released7",  new KeyAction(ctrl, "released7"));
	}
	
	public void setTime(int time){
		timeLbl.setText("Time: "+time);
	}
	
	void setMsg(String s){
		msgLbl.setText(s);
	}
	
	void setScore(boolean player1, int score){
		if(player1) 
			p1Score.setText("Score: "+score);
		else
			p2Score.setText("Score: "+score);
	}
	
	void move(boolean player1, int x, int y){
		String name;
		if(player1){
			board[x][y].setIcon(new ImageIcon("icons/red.jpg"));
			name = p2Name.getText();
		} else{
			board[x][y].setIcon(new ImageIcon("icons/blue.jpg"));
			name = p1Name.getText();
		}
		
		if(name.length() > 25)
			setMsg(name.substring(0, 25) + "...'s turn");
		else
			setMsg(name + "'s turn");
	}

}
