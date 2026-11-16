package checkifmoveislegal

// Time:  O(8 * n) = O(1), grid is a n x n board and n = 8
// Space: O(1)
class Solution {
    private val directions = arrayOf(
        intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0),
        intArrayOf(-1, -1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(1, 1)
    )

    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        for ((dr, dc) in directions) {
            val r = rMove + dr
            val c = cMove + dc
            if (check(board, color, r, c, dr, dc)) {
                return true
            }
        }
        return false
    }

    private fun check(
        board: Array<CharArray>,
        color: Char,
        startR: Int,
        startC: Int,
        dr: Int,
        dc: Int
    ): Boolean {
        var r = startR
        var c = startC
        var l = 2
        while (r >= 0 && r < board.size &&
            c >= 0 && c < board[0].size &&
            board[r][c] != '.'
        ) {
            if (board[r][c] == color) {
                return l >= 3
            }
            r += dr
            c += dc
            ++l
        }
        return false
    }
}
