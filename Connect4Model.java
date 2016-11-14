
public class Connect4Model {
	Connect4View view;
	boolean player1;
	boolean canPause;
	int[][] board;
	int p1Score;
	int p2Score;
	
	public Connect4Model(Connect4View view) {
		this.view = view;
		player1 = true;
		canPause = true;
		board = new int[7][6];
	}
	
	void move(int column){
		column--;	//we receive input 1-7 for the column and it's one less in the array
		if(isColumnFull(column)){
			view.setMsg("That Column is full!");
			return;
		}
		
		int row = 0;
		while((row < 5) && (board[column][row+1] == 0))
			row++;
		
		view.move(player1, column, row);
		board[column][row] = (player1)? 1 : 2;
		if(checkWin())
			view.setMsg("Player" + ((player1)? "1" : "2") + " wins! :D");
		canPause = true;
		player1 = !player1;
	}
	
	boolean isColumnFull(int c){
		return board[c][0] != 0;
	}
	
	boolean checkWin(){
		for(int x = 0; x < 7; x++){
			for(int y = 0; y < 6; y++){
				if(board[x][y] != 0){
					if(x < 4){
						if((board[x][y] & board[x+1][y] & board[x+2][y]  & board[x+3][y]) == board[x][y]) 	//horizontal win ----
							return true;
						if(y < 3)
							if((board[x][y] & board[x+1][y+1] & board[x+2][y+2]  & board[x+3][y+3]) == board[x][y]) //backslash win \
								return true;
					}
					if(y < 3)
						if((board[x][y] & board[x][y+1] & board[x][y+2] & board[x][y+3]) == board[x][y])	//vertical win |
							return true;
					if(y > 2 && x > 2)
						if((board[x][y] & board[x-1][y-1] & board[x-2][y-2]  & board[x-3][y-3]) == board[x][y]) //forward slash win /
							return true;
				}
			}	
		}
		return false;
	}
	
	void pause(){
		if(canPause){
			view.setPanel("pause");
			canPause = false;
		}
		else{
			view.setMsg("Only one pause per turn.");
		}
	}
}
