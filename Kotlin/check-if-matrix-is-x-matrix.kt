package checkifmatrixisxmatrix

// Time:  O(n^2)
// Space: O(1)
class Solution {
    fun checkXMatrix(grid: Array<IntArray>): Boolean {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if ((i == j || i + j == grid.size - 1) != (grid[i][j] != 0)) {
                    return false
                }
            }
        }
        return true
    }
}
