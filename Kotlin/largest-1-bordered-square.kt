package largest1borderedsquare

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val left = Array(grid.size) { grid[it].clone() }
        val top = Array(grid.size) { grid[it].clone() }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    continue
                }
                if (i != 0) {
                    top[i][j] = top[i - 1][j] + 1
                }
                if (j != 0) {
                    left[i][j] = left[i][j - 1] + 1
                }
            }
        }
        for (l in minOf(grid.size, grid[0].size) downTo 1) {
            for (i in 0..grid.size - l) {
                for (j in 0..grid[0].size - l) {
                    if (minOf(
                            top[i + l - 1][j],
                            top[i + l - 1][j + l - 1],
                            left[i][j + l - 1],
                            left[i + l - 1][j + l - 1]
                        ) >= l
                    ) {
                        return l * l
                    }
                }
            }
        }
        return 0
    }
}
