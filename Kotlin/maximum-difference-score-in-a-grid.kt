package maximumdifferencescoreinagrid
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun maxScore(grid: Array<IntArray>): Int {
        var result = Int.MIN_VALUE
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                var mn = Int.MAX_VALUE
                if (i - 1 >= 0) {
                    mn = minOf(mn, grid[i - 1][j])
                }
                if (j - 1 >= 0) {
                    mn = minOf(mn, grid[i][j - 1])
                }
                if (mn != Int.MAX_VALUE) {
                    result = maxOf(result, grid[i][j] - mn)
                    grid[i][j] = minOf(grid[i][j], mn)
                }
            }
        }
        return result
    }
}
