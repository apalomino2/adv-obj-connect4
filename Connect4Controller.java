import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Connect4Controller implements ActionListener{
	Connect4Model model;
	Connect4View view;
	private boolean p1Ready;
	private boolean p2Ready;
	private boolean canPause;
	private int     time;
	
	public Connect4Controller(Connect4Model model, Connect4View view){  
		this.model = model;
		this.view  = view;
		this.view.addListerner(this);
		p1Ready = p2Ready = false;
		canPause = true;
		time = 30;
	}
	
	public void begin(){
		view.begin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String s = btn.getText();
		System.out.println("Clicked: " + s);
		if(s.equals("Play"))
			view.setPanel("pregame"); //skipping pregame panel until keyboard input is enabled
		else if(s.equals("Instructions"))
			view.setPanel("help");
		else if(s.equals("Back"))
			view.setPanel("start");
		else if(s.matches("\\d"))
			model.move(Integer.parseInt(s));
		else if(s.equals("Pause"))
			model.pause();
		else if(s.equals("Unpause"))
			view.setPanel("game");
	}
	
	public void actionPerformed(String s){
		System.out.println("KeyAction " + s);
		
		if(s.equals("aPressed")){
			p1Ready = true;
			view.setPMsg(true, "Player1 Ready!");
			if(p1Ready && p2Ready)
				view.setPanel("game");
		}
		else if(s.equals("aReleased")){
			p1Ready = false;
			view.setPMsg(true, "Press a");
		}
		else if(s.equals("lPressed")){
			p2Ready = true;
			view.setPMsg(false, "Player2 Ready!");
			if(p1Ready && p2Ready)
				view.setPanel("game");
		}
		else if(s.equals("lReleased")){
			p2Ready = false;
			view.setPMsg(false, "Press l");
		}
		else if(s.matches("\\d"))
			model.move(Integer.parseInt(s));
	}
}
