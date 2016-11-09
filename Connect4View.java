import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4View {
	Connect4Controller ctrl;
	private JPanel cardPanel;
	private GamePanel gamePanel;
	private PreGamePanel preGamePanel;
	
	void addListerner(Connect4Controller c){
		ctrl = c;
	}
	
	void begin(){
		JPanel startPanel   = new StartPanel(ctrl);
		JPanel pausePanel   = new PausePanel(ctrl);
		JPanel helpPanel    = new HelpPanel(ctrl);
		preGamePanel 		= new PreGamePanel(ctrl);
		gamePanel    		= new GamePanel(ctrl);
		
		cardPanel = new JPanel(new CardLayout());
		cardPanel.add(startPanel, "start");
		cardPanel.add(preGamePanel, "pregame");
		cardPanel.add(pausePanel, "pause");
		cardPanel.add(helpPanel, "instructions");
		cardPanel.add(gamePanel, "game");
		
		JFrame frame = new JFrame("Connect4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(600, 600));
		frame.getContentPane().add(cardPanel);
		frame.setVisible(true);
	}

	void setPanel(String name){
		System.out.println("Setting " + name + "Panel...");
		CardLayout cl = (CardLayout)cardPanel.getLayout();
		cl.show(cardPanel, name);
		System.out.println("Done.");
	}
	
	void setTime(int time){
		gamePanel.setTime(time);
	}
	
	void setMsg(String s){
		gamePanel.setMsg(s);
	}
	
	void setScore(boolean player1, int score){
		gamePanel.setScore(player1, score);
	}
	
	void move(boolean player1, int x, int y){
		gamePanel.move(player1, x, y);
	}
	
	void setPMsg(boolean player1, String s){
		if(player1)
			preGamePanel.setp1Msg(s);
		else
			preGamePanel.setp2Msg(s);
	}
}
