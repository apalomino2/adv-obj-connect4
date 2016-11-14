import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Controller for a Connect 4 game.
 * @author Abner Palomino 
 */
public class Connect4Controller implements ActionListener{
	/**
	 * Model containing the data for the game.
	 * @see Connect4Model
	 */
	Connect4Model model;
	
	/**
	 * View which displays the game.
	 * @see Connect4View
	 */
	Connect4View view;
	
	/**
	 * Used to determine when player 1 is ready. It will be set to true 
	 * when the pregame panel is showing and the a key is pressed. If 
	 * the a key is released, then it will be set to false. 
	 */
	private boolean p1Ready;
	
	/**
	 * Used to determine when player 2 is ready. It will be set to true 
	 * when the pregame panel is showing and the l key is pressed. If 
	 * the l key is released, then it will be set to false. 
	 */
	private boolean p2Ready;
	
	private boolean canPause;
	private char 	current;
	private int     time;
	
	/**
	 * aaaa
	 * @param model
	 * @param view
	 */
	public Connect4Controller(Connect4Model model, Connect4View view){  
		this.model = model;
		this.view  = view;
		this.view.addListerner(this);
		p1Ready  = p2Ready = false;
		current  = ' ';
		canPause = true;
		time     = 30;
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
			view.setPanel("pregame"); 
		else if(s.equals("Instructions"))
			view.setPanel("help");
		else if(s.equals("Back"))
			view.setPanel("start");
		else if(s.matches("\\d")){
			canPause = true;
			model.move(Integer.parseInt(s));
		}
		else if(s.equals("Pause") && canPause){
			canPause = false;
			model.pause();
		}
		else if(s.equals("Unpause"))
			view.setPanel("game");
	}
	
	public void actionPerformed(String s){
		System.out.println("KeyAction " + s);
		
		if(s.matches("[a,l].*"))
			pregameAction(s);
		else if(s.matches(".*\\d"))
			keyboardNumberAction(s);
	}
	
	private void pregameAction(String s){
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
	}
	
	private void keyboardNumberAction(String s){
		if(current == ' '){
			int d = Integer.parseInt(s.substring(s.length()-1));
			model.move(d);
			canPause = true;
			current = s.charAt(s.length()-1);
		}
		if(s.charAt(s.length()-1) == current && s.matches("released."))
			current = ' ';
	}
}
