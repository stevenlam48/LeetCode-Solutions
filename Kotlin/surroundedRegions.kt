package surroundedRegionsOld

// LeetCode, Surrounded Regions
// BFS method
// Complexity:
//     O(n) time, O(n) space

class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty()) return
        val m = board.size
        val n = board[0].size

        // do BFS from up and down boundary
        for (i in 0 until n) {
            bfs(board, 0, i)
            bfs(board, m - 1, i)
        }

        // do BFS from left and right boundary
        for (j in 1 until m - 1) {
            bfs(board, j, 0)
            bfs(board, j, n - 1)
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                // mark the BFS-unvisited node with 'X'
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if (board[i][j] == '+') {
                    // mark the BFS-visited node with 'O'
                    board[i][j] = 'O'
                }
            }
        }
    }

    private fun bfs(board: Array<CharArray>, i: Int, j: Int) {
        val q = ArrayDeque<Pair<Int, Int>>()
        val m = board.size
        val n = board[0].size

        val isValid = { s: Pair<Int, Int> ->
            val x = s.first
            val y = s.second
            x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'
        }

        val stateExtend = { s: Pair<Int, Int> ->
            val result = ArrayList<Pair<Int, Int>>()
            val x = s.first
            val y = s.second
            val newStates = arrayOf(Pair(x - 1, y), Pair(x + 1, y), Pair(x, y - 1), Pair(x, y + 1))
            for (k in 0 until 4) {
                if (isValid(newStates[k])) {
                    // mark
                    board[newStates[k].first][newStates[k].second] = '+'
                    result.add(newStates[k])
                }
            }
            result
        }

        val start = Pair(i, j)
        if (isValid(start)) {
            board[i][j] = '+'
            q.add(start)
        }

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            val newStates = stateExtend(cur)
            for (s in newStates) q.add(s)
        }
    }
}
