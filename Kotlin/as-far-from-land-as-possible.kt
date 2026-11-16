package asfarfromlandaspossible

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun maxDistance(grid: Array<IntArray>): Int {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        var q = ArrayDeque<IntArray>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] != 0) {
                    q.addLast(intArrayOf(i, j))
                }
            }
        }
        if (q.size == grid.size * grid[0].size) {
            return -1
        }
        var level = -1
        while (q.isNotEmpty()) {
            val nextQ = ArrayDeque<IntArray>()
            while (q.isNotEmpty()) {
                val (x, y) = q.removeFirst()
                for (d in directions) {
                    val nx = x + d[0]
                    val ny = y + d[1]
                    if (!(0 <= nx && nx < grid.size &&
                          0 <= ny && ny < grid[0].size &&
                          grid[nx][ny] == 0)) {
                        continue
                    }
                    nextQ.addLast(intArrayOf(nx, ny))
                    grid[nx][ny] = 1
                }
            }
            q = nextQ
            ++level
        }
        return level
    }
}
