package minPathSum

// Time Complexity: O(mn)
// Space Complexity: O(mn)

class Solution {
    private val memo = HashMap<Long, Int>()

    fun minPathSum(grid: Array<IntArray>): Int {
        return minPathSumImpl(grid, grid.size - 1, grid[0].size - 1)
    }

    private fun minPathSumImpl(grid: Array<IntArray>, i: Int, j: Int): Int {
        val key = (i.toLong() shl 32) or (j.toLong() and 0xffffffffL)
        memo[key]?.let { return it }
        if (i == 0 && j == 0) {
            return grid[i][j]
        }
        if (i < 0 || j < 0) {
            return Int.MAX_VALUE
        }
        val result = grid[i][j] + minOf(minPathSumImpl(grid, i - 1, j), minPathSumImpl(grid, i, j - 1))
        memo[key] = result
        return result
    }
}
