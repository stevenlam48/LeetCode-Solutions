package removealloneswithrowandcolumnflips
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun removeOnes(grid: Array<IntArray>): Boolean {
        for (i in 1 until grid.size) {
            if (grid[i].contentEquals(grid[0])) {
                continue
            }
            for (j in grid[0].indices) {
                if (grid[i][j] == grid[0][j]) {
                    return false
                }
            }
        }
        return true
    }
}
