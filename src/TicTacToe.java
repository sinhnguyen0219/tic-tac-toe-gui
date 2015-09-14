package edu.jsu.mcis;

public class TicTacToe {
	//private static Scanner scan = new Scanner(System.in);
	//all these below were static
	public static int row, col;
	public static char[][] board = new char[3][3];
	public static char who = 'X';
	public static int turns = 0;
	private static String wonHow = "  ";
	/*	
	public static void main(String[] args) {
	NewGame();	
	}
	*/	
	
	public TicTacToe(){
		turns = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = '_';
			}
		}
	}
	
	/*private void NewGame(){
		//the Constructor "TicTacToe" already does this
		//ClearBoard();
		PrintBoard();
		while (StillRunning()){
		Winner();
		//out.println();
		out.print("Player " + who + ",enter a row: ");
		row = scan.nextInt()-1;
		out.print("Player " + who + ",enter a col: ");
		col = scan.nextInt()-1;
		Mark(row, col);
		PrintBoard();
		GetWinner();
		Winner();
		}
	}
	*/
	public void ClearBoard(){
		turns = 0;
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = '_';
			}
		}
	}
	
	/*private void PrintBoard(){
		for (int i = 0; i < 3; i++){
			//out.println();
			for (int j = 0; j < 3; j++){
				{if (board[i][j] == '_')
						out.print('_');
				else 
					out.print(board[i][j]);
				}
			}
		}
	}	
	*/
	public boolean IsBoardEmpty(){
		boolean empty = true;
		if (board[0][0] == board[0][1] 
				&& board[0][0] == board[0][2]
						&& board[0][2] == board[1][0] 
								&&	board[1][0] == board[1][1]
										& board[1][0] == board[1][2]
												&& board[1][2] == board[2][0]
														&& board[2][0] == board[2][1]
																&& board[2][0] == board[2][2]
																		&& board[2][2] == '_'){
			empty = true;
		}else {
				empty = false;
		}
		return empty;
		}
	
	public void Mark( int rMove, int cMove){
		if (board[rMove][cMove] == '_'){
			board[rMove][cMove] = who;
			 if (who == 'X'){
					who = 'O';
			 }
			 else {
					who = 'X';}
			 turns++;
		}

		else {
			UnableToMark();
			//out.println("\n\n" + UnableToMark());
		}
	}

	public String GetMark(int rMove, int cMove){
		String character = Character.toString(board[rMove][cMove]);
		String location = character;
		return location;
	}
	
	/*

	public static String CheckLocation(int rMove, int cMove){
		String character = Character.toString(board[rMove][cMove]);
		String location =  character;
		return location;
	}
	*/
	
	public String UnableToMark(){
		return "This tile has already been taken.";		
	}
	
	public boolean StillRunning(){
		if(turns == 9)
			return false;
		 else 
			 return true;
		}
	
	private boolean HorizontalWin(){
		if (board[0][0] == board[0][1] && 
				board[0][0] == board[0][2] &&
				board[0][0] != '_')
			return true;
		if (board[1][0] == board[1][1] && 
				board[1][0] == board[1][2] &&
				board[1][0] != '_')
			return true;
		if (board[2][0] == board[2][1] && 
				board[2][0] == board[2][2] &&
				board[2][0] != '_'){
			return true;
		}
		else 
			return false;
	}
	
	private boolean VerticalWin(){
		if (board[0][0] == board[1][0] && 
				board[0][0] == board[2][0] &&
				board[0][0] != '_' )
			return true;
		if (board[0][1] == board[1][1] && 
				board[0][1] == board[2][1] &&
				board[0][1] != '_')
			return true;
		if (board[0][2] == board[1][2] && 
				board[0][2] == board[2][2] &&
				board[0][2] != '_')
			return true;
		else 
			return false;
	}
	
	private boolean DiagonalWin(){
		if (board[0][0] == board[1][1] && 
				board[0][0] == board[2][2] &&
				board[0][0] != '_')
			return true;
		if (board[0][2] == board[1][1] && 
				board[0][2] == board[2][0] &&
				board[0][2] != '_')
			return true;
		else 
			return false;
	}
	
	public String GetWinner(){
		if (turns != 10){
				if (DiagonalWin()){
					wonHow = "Diagonal";
				//	turns = 10;
				}
				else if (HorizontalWin()){
					wonHow = "Horizontal";
				//	turns = 10;
				}
				else if (VerticalWin()){
					wonHow = "Vertical";
					//turns = 10;
				}	
				else {
					return "Running";
				}
				
		}
		else if (turns == 10){
			wonHow = "Tie";
		}
		return Winner();
		
		}
	
	public String Winner(){
		String winner = "";
		if (wonHow == "Diagonal"){
		 if (who == 'X'){
				who = 'O';
		 }
		 else {
				who = 'X';}
			if (who == 'X'){
				winner = "X";
			}else {
				winner = "O";
			}
		}
		else if (wonHow == "Horizontal"){
			 if (who == 'X'){
					who = 'O';
			 }
			 else {
					who = 'X';}
				if (who == 'X'){
					winner = "X";
				}else {
					winner = "O";
				}
			}
		else if (wonHow == "Vertical"){
			 if (who == 'X'){
					who = 'O';
			 }
			 else {
					who = 'X';}
				if (who == 'X'){
					winner = "X";
				}else {
					winner = "O";
				}
			}else if (wonHow == "Tie"){
				 if (who == 'X'){
						who = 'O';
				 }
				 else {
					 who = 'O';
				 }
				winner = "TIE";
		}
		

		
		return winner;
	}

}


