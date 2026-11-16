package gridgame

// Time:  O(n)
// Space: O(1)

class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        var result = Long.MAX_VALUE
        var left = 0L
        var right = grid[0].sumOf { it.toLong() }
        for (i in grid[0].indices) {
            right -= grid[0][i]
            result = minOf(result, maxOf(left, right))
            left += grid[1][i]
        }
        return result
    }
}
