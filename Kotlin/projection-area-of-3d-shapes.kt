package projectionareaof3dshapes

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun projectionArea(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            var maxRow = 0
            var maxCol = 0
            for (j in grid.indices) {
                if (grid[i][j] > 0) {
                    ++result
                }
                maxRow = maxOf(maxRow, grid[i][j])
                maxCol = maxOf(maxCol, grid[j][i])
            }
            result += maxRow + maxCol
        }
        return result
    }
}
