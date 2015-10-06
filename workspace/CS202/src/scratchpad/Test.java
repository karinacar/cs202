package scratchpad;

public class Test {

	public static void main(String[] args) {
		String[][] myBoard = makeChessboard();
		printChessboard(myBoard);
	}

	public static String[][] makeChessboard() {
		String[][] chessboard = new String[8][8];

		for (int i = chessboard.length; i > 0; i--) {
			for (int j = 0; j < 8; j++) {
				char square = (char) (int) ('A' + j);
				chessboard[8-i][j] = String.valueOf(square) + i;				
			}			
		}

		return chessboard;
	}

	public static void printChessboard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%5s", board[i][j]);
			}
			System.out.println();
		}
	}
}
