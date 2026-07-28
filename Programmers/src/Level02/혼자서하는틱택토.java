package Level02;

class Solution {
	public int solution(String[] board) {
		int oCnt = 0;
		int xCnt = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'O')
					oCnt++;
				if (board[i].charAt(j) == 'X')
					xCnt++;
			}
		}

		if (xCnt > oCnt) {
			return 0;
		}

		if (oCnt - xCnt > 1) {
			return 0;
		}

		boolean oWin = check(board, 'O');
		boolean xWin = check(board, 'X');

		if (oWin && xWin) {
			return 0;
		}

		if (oWin && xCnt != oCnt - 1) {
			return 0;
		}

		if (xWin && oCnt != xCnt) {
			return 0;
		}

		return 1;
	}

	boolean check(String[] board, char turn) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == turn && board[i].charAt(1) == turn && board[i].charAt(2) == turn)
				return true;

			if (board[0].charAt(i) == turn && board[1].charAt(i) == turn && board[2].charAt(i) == turn)
				return true;
		}

		if (board[0].charAt(0) == turn && board[1].charAt(1) == turn && board[2].charAt(2) == turn)
			return true;

		if (board[0].charAt(2) == turn && board[1].charAt(1) == turn && board[2].charAt(0) == turn)
			return true;

		return false;

	}
}
