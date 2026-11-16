package solveSudoku

// Time Complexity: O((n!)^n)
// Space Complexiy: O(n^2)

class Solution {
    fun solveSudoku(board: Array<CharArray>) {
        solver(board)
    }

    private fun solver(board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == '.') {
                    for (k in 0 until 9) {
                        board[i][j] = '1' + k
                        if (isValid(board, i, j) && solver(board)) {
                            return true
                        }
                        board[i][j] = '.'
                    }
                    return false
                }
            }
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, x: Int, y: Int): Boolean {
        for (i in 0 until 9) {
            if (i != x && board[i][y] == board[x][y]) {
                return false
            }
        }

        for (j in 0 until 9) {
            if (j != y && board[x][j] == board[x][y]) {
                return false
            }
        }

        for (i in 3 * (x / 3) until 3 * (x / 3 + 1)) {
            for (j in 3 * (y / 3) until 3 * (y / 3 + 1)) {
                if (!(i == x && j == y) && board[i][j] == board[x][y]) {
                    return false
                }
            }
        }

        return true
    }
}
