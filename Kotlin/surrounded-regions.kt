package surroundedregions

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty()) {
            return
        }

        val q = ArrayDeque<Pair<Int, Int>>()
        for (i in board.indices) {
            if (board[i][0] == 'O') {
                board[i][0] = 'V'
                q.add(Pair(i, 0))
            }
            if (board[i][board[0].size - 1] == 'O') {
                board[i][board[0].size - 1] = 'V'
                q.add(Pair(i, board[0].size - 1))
            }
        }

        for (j in 1 until board[0].size - 1) {
            if (board[0][j] == 'O') {
                board[0][j] = 'V'
                q.add(Pair(0, j))
            }
            if (board[board.size - 1][j] == 'O') {
                board[board.size - 1][j] = 'V'
                q.add(Pair(board.size - 1, j))
            }
        }
        val directions = arrayOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))
        while (q.isNotEmpty()) {
            val (i, j) = q.removeFirst()
            for (d in directions) {
                val x = i + d.first
                val y = j + d.second
                if (0 <= x && x < board.size &&
                    0 <= y && y < board[0].size &&
                    board[x][y] == 'O'
                ) {
                    board[x][y] = 'V'
                    q.add(Pair(x, y))
                }
            }
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] != 'V') {
                    board[i][j] = 'X'
                } else {
                    board[i][j] = 'O'
                }
            }
        }
    }
}
