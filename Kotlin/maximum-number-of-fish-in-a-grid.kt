package maximumnumberoffishinagrid

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun findMaxFish(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )

        fun bfs(si: Int, sj: Int): Int {
            var result = grid[si][sj]
            grid[si][sj] = 0
            var q = ArrayDeque<IntArray>()
            q.addLast(intArrayOf(si, sj))
            while (q.isNotEmpty()) {
                val next = ArrayDeque<IntArray>()
                for (cell in q) {
                    for (d in directions) {
                        val ni = cell[0] + d[0]
                        val nj = cell[1] + d[1]
                        if (!(ni in grid.indices && nj in grid[0].indices && grid[ni][nj] != 0)) {
                            continue
                        }
                        result += grid[ni][nj]
                        grid[ni][nj] = 0
                        next.addLast(intArrayOf(ni, nj))
                    }
                }
                q = next
            }
            return result
        }

        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != 0) {
                    result = maxOf(result, bfs(i, j))
                }
            }
        }
        return result
    }
}
