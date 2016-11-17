import static org.junit.Assert.*;

import org.junit.Test;

public class Connect4ModelTest {

	@Test
	public void testisColumnFull(){
		Connect4View       view       = new Connect4View();
		Connect4Model      model      = new Connect4Model(view);
		Connect4Controller controller = new Connect4Controller(model, view);
			
		assertEquals(false, Connect4Model.isColumnFull(1));
		assertFalse(Connect4Model.isColumnFull(0));
		//assertNotSame(Connect4Model.isColumnFull(0), Connect4Model.isColumnFull(1));
	}
	
	@Test
	public void testcheckwin(){
		Connect4View       view       = new Connect4View();
		Connect4Model      model      = new Connect4Model(view);
		Connect4Controller controller = new Connect4Controller(model, view);
	
		assertEquals(false, Connect4Model.checkWin());
		//assertTrue(Connect4Model.checkWin());
		assertFalse(Connect4Model.checkWin());
	
	}
	
	@Test
	public void testpause(){
		Connect4View       view       = new Connect4View();
		Connect4Model      model      = new Connect4Model(view);
		Connect4Controller controller = new Connect4Controller(model, view);
		
	}
	
	@Test
	public void testmove(){
		Connect4View       view       = new Connect4View();
		Connect4Model      model      = new Connect4Model(view);
		Connect4Controller controller = new Connect4Controller(model, view);
		
		model.move(7);
		assertEquals(6, model.board.length);
	
		assertEquals(0, model.getBoardValue(6, 0));
		assertNotNull(model);
	}
	
	
	
	
	
	

}
