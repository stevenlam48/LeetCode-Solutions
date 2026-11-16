package surfaceareaof3dshapes

import kotlin.math.min

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun surfaceArea(grid: Array<IntArray>): Int {
        var result = 0
        for (i in grid.indices) {
            for (j in grid.indices) {
                if (grid[i][j] != 0) {
                    result += grid[i][j] * 4 + 2
                }
                if (i != 0) {
                    result -= min(grid[i][j], grid[i - 1][j]) * 2
                }
                if (j != 0) {
                    result -= min(grid[i][j], grid[i][j - 1]) * 2
                }
            }
        }
        return result
    }
}
