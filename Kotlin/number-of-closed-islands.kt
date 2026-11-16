package numberofclosedislands
// Time:  O(m * n)
// Space: O(1)

class Solution {
    private val directions = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    fun closedIsland(grid: Array<IntArray>): Int {
        for (j in 0 until grid[0].size) {
            fill(grid, 0, j)
            fill(grid, grid.size - 1, j)
        }
        for (i in 1 until grid.size - 1) {
            fill(grid, i, 0)
            fill(grid, i, grid[0].size - 1)
        }
        var result = 0
        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid[0].size - 1) {
                if (fill(grid, i, j)) {
                    ++result
                }
            }
        }
        return result
    }

    private fun fill(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[i].size || grid[i][j] != 0) {
            return false
        }
        grid[i][j] = 1
        for ((dx, dy) in directions) {
            fill(grid, i + dx, j + dy)
        }
        return true
    }
}
