package bestmeetingpoint

// Time:  O(m * n)
// Space: O(m + n)

import kotlin.math.abs

class Solution {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        val x = mutableListOf<Int>()
        val y = mutableListOf<Int>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != 0) {
                    x.add(i)
                    y.add(j)
                }
            }
        }
        x.sort()
        y.sort()
        val midX = x[x.size / 2]
        val midY = y[y.size / 2]
        var sum = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != 0) {
                    sum += abs(midX - i) + abs(midY - j)
                }
            }
        }
        return sum
    }
}
