package checkknighttourconfiguration

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun checkValidGrid(grid: Array<IntArray>): Boolean {
        if (grid[0][0] != 0) {
            return false
        }
        val lookup = Array(grid.size * grid[0].size) { intArrayOf(0, 0) }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                lookup[grid[i][j]] = intArrayOf(i, j)
            }
        }
        for (i in 0 until lookup.size - 1) {
            val dx = kotlin.math.abs(lookup[i + 1][0] - lookup[i][0])
            val dy = kotlin.math.abs(lookup[i + 1][1] - lookup[i][1])
            if (!(minOf(dx, dy) == 1 && maxOf(dx, dy) == 2)) {
                return false
            }
        }
        return true
    }
}
