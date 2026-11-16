package pathwithmaximumgold

// Time:  O(m^2 * n^2)
// Space: O(m * n)

class Solution {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != 0) {
                    result = maxOf(result, backtracking(grid, i, j))
                }
            }
        }
        return result
    }

    private fun backtracking(grid: Array<IntArray>, i: Int, j: Int): Int {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        var result = 0
        grid[i][j] *= -1
        for (d in directions) {
            val ni = i + d[0]
            val nj = j + d[1]
            if (!(0 <= ni && ni < grid.size &&
                    0 <= nj && nj < grid[0].size &&
                    grid[ni][nj] > 0)) {
                continue
            }
            result = maxOf(result, backtracking(grid, ni, nj))
        }
        grid[i][j] *= -1
        return grid[i][j] + result
    }
}
