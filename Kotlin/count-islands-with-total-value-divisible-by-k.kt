package countislandswithtotalvaluedivisiblebyk

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )

        fun bfs(row: Int, column: Int): Boolean {
            if (grid[row][column] == 0) {
                return false
            }
            var total = grid[row][column] % k
            grid[row][column] = 0
            var queue = listOf(Pair(row, column))
            while (queue.isNotEmpty()) {
                val newQueue = mutableListOf<Pair<Int, Int>>()
                for ((i, j) in queue) {
                    for ((di, dj) in directions) {
                        val ni = i + di
                        val nj = j + dj
                        if (!(ni in grid.indices && nj in grid[0].indices && grid[ni][nj] != 0)) {
                            continue
                        }
                        total = (total + grid[ni][nj]) % k
                        grid[ni][nj] = 0
                        newQueue.add(Pair(ni, nj))
                    }
                }
                queue = newQueue
            }
            return total == 0
        }

        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (bfs(i, j)) {
                    ++result
                }
            }
        }
        return result
    }
}
