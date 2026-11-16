package maxareaofisland

// Time:  O(m * n)
// Space: O(m * n), the max depth of dfs may be m * n

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val area = IntArray(1)
                if (dfs(i, j, grid, area)) {
                    result = maxOf(result, area[0])
                }
            }
        }
        return result
    }

    private fun dfs(i: Int, j: Int, grid: Array<IntArray>, area: IntArray): Boolean {
        if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] <= 0) {
            return false
        }
        grid[i][j] *= -1
        area[0]++
        for (d in directions) {
            dfs(i + d.first, j + d.second, grid, area)
        }
        return true
    }

    companion object {
        private val directions = arrayOf(-1 to 0, 1 to 0, 0 to 1, 0 to -1)
    }
}
