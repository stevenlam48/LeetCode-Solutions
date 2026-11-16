package validtictactoestate

// Time:  O(1)
// Space: O(1)

class Solution {
    fun validTicTacToe(board: List<String>): Boolean {
        val FIRST = 'X'
        val SECOND = 'O'
        val xCount = board.sumOf { row -> row.count { it == FIRST } }
        val oCount = board.sumOf { row -> row.count { it == SECOND } }
        if (oCount != xCount - 1 && oCount != xCount) {
            return false
        }
        if (isWin(board, FIRST) && oCount != xCount - 1) {
            return false
        }
        if (isWin(board, SECOND) && oCount != xCount) {
            return false
        }
        return true
    }

    private fun isWin(board: List<String>, player: Char): Boolean {
        for (i in board.indices) {
            if (board[i].all { it == player }) {
                return true
            }
            if (board.all { it[i] == player }) {
                return true
            }
        }

        return (player == board[1][1] &&
            board[1][1] == board[0][0] &&
            board[0][0] == board[2][2]) ||
            (player == board[1][1] &&
                board[1][1] == board[0][2] &&
                board[0][2] == board[2][0])
    }
}
