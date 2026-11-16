package countserversthatcommunicate

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val rows = IntArray(grid.size)
        val columns = IntArray(grid[0].size)
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] != 0) {
                    ++rows[i]
                    ++columns[j]
                }
            }
        }
        var result = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] != 0 && (rows[i] > 1 || columns[j] > 1)) {
                    ++result
                }
            }
        }
        return result
    }
}
