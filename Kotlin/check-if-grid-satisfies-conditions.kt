package checkifgridsatisfiesconditions

// Time:  O(m * n)
// Space: O(1)
class Solution {
    fun satisfiesConditions(grid: Array<IntArray>): Boolean {
        for (j in grid[0].indices) {
            for (i in 0 until grid.size - 1) {
                if (grid[i][j] != grid[i + 1][j]) {
                    return false
                }
            }
            if (j + 1 < grid[0].size && grid[0][j] == grid[0][j + 1]) {
                return false
            }
        }
        return true
    }
}
