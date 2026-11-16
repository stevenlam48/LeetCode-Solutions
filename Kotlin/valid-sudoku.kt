package validsudoku

// Time:  O(9^2)
// Space: O(9)

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            if (anyDuplicate(board, i, i + 1, 0, 9)) {
                return false
            }
        }

        for (j in board.indices) {
            if (anyDuplicate(board, 0, 9, j, j + 1)) {
                return false
            }
        }

        for (i in 0 until 9 step 3) {
            for (j in 0 until 9 step 3) {
                if (anyDuplicate(board, i, i + 3, j, j + 3)) {
                    return false
                }
            }
        }
        return true
    }

    private fun anyDuplicate(board: Array<CharArray>, startRow: Int, endRow: Int,
                             startCol: Int, endCol: Int): Boolean {
        val isPresent = BooleanArray(9)
        for (i in startRow until endRow) {
            for (j in startCol until endCol) {
                if (board[i][j] != '.') {
                    val idx = board[i][j] - '1'
                    if (isPresent[idx]) {
                        return true
                    }
                    isPresent[idx] = true
                }
            }
        }
        return false
    }
}
