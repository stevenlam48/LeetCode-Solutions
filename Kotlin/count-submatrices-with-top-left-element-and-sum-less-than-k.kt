package countsubmatriceswithtopleftelementandsumlessthank
// Time:  O(n * m)
// Space: O(1)

class Solution {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i > 0) {
                    grid[i][j] += grid[i - 1][j]
                }
                if (j > 0) {
                    grid[i][j] += grid[i][j - 1]
                }
                if (i > 0 && j > 0) {
                    grid[i][j] -= grid[i - 1][j - 1]
                }
                if (grid[i][j] <= k) {
                    ++result
                }
            }
        }
        return result
    }
}
