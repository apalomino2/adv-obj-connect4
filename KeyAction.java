import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class KeyAction extends AbstractAction{
		private Connect4Controller ctrl;
		private String s;
		private boolean pressed;

		public KeyAction(Connect4Controller ctrl, String s){
			this.ctrl = ctrl;
			this.s    = s;
			pressed = false;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ctrl.actionPerformed(s);
		}
}
