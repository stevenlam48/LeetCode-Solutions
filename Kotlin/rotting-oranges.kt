package rottingoranges

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var count = 0
        val q = ArrayDeque<IntArray>()
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] == 2) {
                    q.addLast(intArrayOf(r, c, 0))
                } else if (grid[r][c] == 1) {
                    ++count
                }
            }
        }

        var result = 0
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            val r = cur[0]
            val c = cur[1]
            result = cur[2]
            for (d in DIRECTIONS) {
                val nr = r + d[0]
                val nc = c + d[1]
                if (!(0 <= nr && nr < grid.size && 0 <= nc && nc < grid[r].size)) {
                    continue
                }
                if (grid[nr][nc] == 1) {
                    --count
                    grid[nr][nc] = 2
                    q.addLast(intArrayOf(nr, nc, result + 1))
                }
            }
        }
        return if (count == 0) result else -1
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
    }
}
