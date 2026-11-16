package findtheminimumareatocoverallonesi

// Time:  O(n * m)
// Space: O(1)

// array
class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
        var minR = grid.size
        var maxR = -1
        var minC = grid[0].size
        var maxC = -1
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    continue
                }
                minR = minOf(minR, i)
                maxR = maxOf(maxR, i)
                minC = minOf(minC, j)
                maxC = maxOf(maxC, j)
            }
        }
        return (maxR - minR + 1) * (maxC - minC + 1)
    }
}
