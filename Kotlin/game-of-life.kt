package gameoflife

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun gameOfLife(board: Array<IntArray>) {
        val m = board.size
        val n = if (m > 0) board[0].size else 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                var count = 0
                for (I in maxOf(i - 1, 0) until minOf(i + 2, m)) {
                    for (J in maxOf(j - 1, 0) until minOf(j + 2, n)) {
                        count += board[I][J] and 1
                    }
                }
                if ((count == 4 && board[i][j] != 0) || count == 3) {
                    board[i][j] = board[i][j] or 2
                }
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                board[i][j] = board[i][j] shr 1
            }
        }
    }
}
