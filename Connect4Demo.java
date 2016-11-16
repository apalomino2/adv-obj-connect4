public class Connect4Demo {
	public static void main(String[] args) {
		Connect4View       view       = new Connect4View();
		Connect4Model      model      = new Connect4Model(view);
		Connect4Controller controller = new Connect4Controller(model, view);
		view.show();
	}
}
