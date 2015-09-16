

public class TicTacToe {
	private char[][] board = new char[3][3];
	private char who = 'X';
	private int turns = 0;
	private String wonHow = "  ";
	
	public TicTacToe(){
		turns = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = ' ';
			}
		}
	}

	public void Mark( int rMove, int cMove){
		if (board[rMove][cMove] == ' '){
			board[rMove][cMove] = who;
			 if (who == 'X'){
					who = 'O';
			 } else {
					who = 'X';}
			 turns++;
		}

	}

	public String getMark(int rMove, int cMove){
		String character = Character.toString(board[rMove][cMove]);
		String location = character;
		return location;
	}
	
	public String whoIsWinner(){
		if((board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != ' ')
			|| (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != ' ')
			|| (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != ' ')
			|| (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != ' ' )
			|| (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != ' ')
			|| (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != ' ')
			|| (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ')
			|| (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' '))
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


