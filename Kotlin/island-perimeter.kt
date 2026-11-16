package islandperimeter

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var count = 0
        var repeat = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    ++count
                    if (i != 0 && grid[i - 1][j] == 1) {
                        ++repeat
                    }
                    if (j != 0 && grid[i][j - 1] == 1) {
                        ++repeat
                    }
                }
            }
        }
        return 4 * count - 2 * repeat
    }
}
