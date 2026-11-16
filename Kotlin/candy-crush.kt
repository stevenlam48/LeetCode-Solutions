package candycrush

// Time:  O((R * C)^2)
// Space: O(1)

class Solution {
    fun candyCrush(board: Array<IntArray>): Array<IntArray> {
        val R = board.size
        val C = board[0].size
        var changed = true

        while (changed) {
            changed = false

            for (r in 0 until R) {
                for (c in 0 until C - 2) {
                    val v = Math.abs(board[r][c])
                    if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                        board[r][c] = -v
                        board[r][c + 1] = -v
                        board[r][c + 2] = -v
                        changed = true
                    }
                }
            }

            for (r in 0 until R - 2) {
                for (c in 0 until C) {
                    val v = Math.abs(board[r][c])
                    if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                        board[r][c] = -v
                        board[r + 1][c] = -v
                        board[r + 2][c] = -v
                        changed = true
                    }
                }
            }

            for (c in 0 until C) {
                var emptyR = R - 1
                for (r in R - 1 downTo 0) {
                    if (board[r][c] > 0) {
                        board[emptyR--][c] = board[r][c]
                    }
                }
                for (r in emptyR downTo 0) {
                    board[r][c] = 0
                }
            }
        }

        return board
    }
}
