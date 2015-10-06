package scratchpad;

public class Chessboard {	
	private String[][] board;
	
	public Chessboard(){
		board = makeChessboard();
	}	
	public Chessboard(String[][] board){
		this.board = board;
	}
	
	public static String[][] makeChessboard() {
		String[][] chessboard = new String[8][8];

		for (int i = chessboard.length; i > 0; i--) {
			for (int j = 0; j < 8; j++) {
				char square = (char)('A' + j);
				chessboard[8-i][j] = String.valueOf(square) + i;				
			}			
		}

		return chessboard;
	}

	public void printChessboard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%5s", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public String[][] getBoard() {
		return board;
	}
	
	public void setBoard(String[][] board) {
		this.board = board;
	}
	
}
