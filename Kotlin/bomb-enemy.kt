package bombenemy

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun maxKilledEnemies(grid: Array<CharArray>): Int {
        var result = 0
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return result
        }

        val down = Array(grid.size) { IntArray(grid[0].size) }
        val right = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.size - 1 downTo 0) {
            for (j in grid[0].size - 1 downTo 0) {
                if (grid[i][j] != 'W') {
                    if (i + 1 < grid.size) {
                        down[i][j] = down[i + 1][j]
                    }
                    if (j + 1 < grid[0].size) {
                        right[i][j] = right[i][j + 1]
                    }
                    if (grid[i][j] == 'E') {
                        ++down[i][j]
                        ++right[i][j]
                    }
                }
            }
        }

        var left = 0
        val up = IntArray(grid[0].size)
        for (i in grid.indices) {
            left = 0
            for (j in grid[0].indices) {
                if (grid[i][j] == 'W') {
                    up[j] = 0
                    left = 0
                } else if (grid[i][j] == 'E') {
                    ++up[j]
                    ++left
                } else {
                    result = maxOf(result, left + up[j] + right[i][j] + down[i][j])
                }
            }
        }

        return result
    }
}
