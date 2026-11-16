package maxincreasetokeepcityskyline

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val rowMaxes = IntArray(grid.size)
        val colMaxes = IntArray(grid[0].size)
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                rowMaxes[r] = maxOf(rowMaxes[r], grid[r][c])
                colMaxes[c] = maxOf(colMaxes[c], grid[r][c])
            }
        }
        var result = 0
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                result += minOf(rowMaxes[r], colMaxes[c]) - grid[r][c]
            }
        }
        return result
    }
}
