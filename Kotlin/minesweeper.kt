package minesweeper

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X'
            return board
        }
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(click[0], click[1]))
        while (stk.isNotEmpty()) {
            val cell = stk.removeLast()
            val r = cell[0]
            val c = cell[1]
            var cnt = 0
            val adj = mutableListOf<IntArray>()
            for (dr in -1..1) {
                for (dc in -1..1) {
                    if (dr == 0 && dc == 0) {
                        continue
                    }
                    val nr = r + dr
                    val nc = c + dc
                    if (!(0 <= nr && nr < board.size && 0 <= nc && nc < board[0].size)) {
                        continue
                    }
                    if (board[nr][nc] == 'M') {
                        ++cnt
                    } else if (board[nr][nc] == 'E') {
                        adj.add(intArrayOf(nr, nc))
                    }
                }
            }
            if (cnt > 0) {
                board[r][c] = '0' + cnt
                continue
            }
            board[r][c] = 'B'
            for (p in adj) {
                board[p[0]][p[1]] = ' '
                stk.addLast(p)
            }
        }
        return board
    }
}
