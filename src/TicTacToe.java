
public class TicTacToe {
	private char[][] board = new char[3][3];
	private char who = 'X';
	private int turns = 0;
	private String wonHow = "  ";
	
	public TicTacToe(){
		turns = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = '_';
			}
		}
	}

	public void Mark( int rMove, int cMove){
		if (board[rMove][cMove] == '_'){
			board[rMove][cMove] = who;
			 if (who == 'X'){
					who = 'O';
			 } else {
					who = 'X';}
			 turns++;
		}

	}

	public String GetMark(int rMove, int cMove){
		String character = Character.toString(board[rMove][cMove]);
		String location = character;
		return location;
	}
	
	public String whoIsWinner(){
		if((board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '_')
			|| (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '_')
			|| (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != '_')
			|| (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '_' )
			|| (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '_')
			|| (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '_')
			|| (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '_')
			|| (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '_'))
		{
			if (who == 'X'){
			wonHow = "O";
			}
			else {
				wonHow = "X";
			}
		}
		else if ((turns == 9 && wonHow != "X") || (turns == 9 && wonHow != "O")) {
			wonHow = "TIE" ;
		}
		else {
			return "";
		}
		return wonHow;
	}
}


