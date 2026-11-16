package battleshipsinaboard

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun countBattleships(board: Array<CharArray>): Int {
        if (board.isEmpty() || board[0].isEmpty()) {
            return 0
        }

        var count = 0
        for (i in board.indices) {
            for (j in board[0].indices) {
                count += if (board[i][j] == 'X' &&
                    (i == 0 || board[i - 1][j] != 'X') &&
                    (j == 0 || board[i][j - 1] != 'X')) 1 else 0
            }
        }
        return count
    }
}
