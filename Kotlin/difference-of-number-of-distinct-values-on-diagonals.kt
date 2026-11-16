package differenceofnumberofdistinctvaluesondiagonals

import kotlin.math.abs
import kotlin.math.min

// Time:  O(m * n)
// Space: O(min(m, n))

// prefix sum
class Solution {
    fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val result = Array(m) { IntArray(n) }

        fun update(i0: Int, j0: Int) {
            val lookup = HashSet<Int>()
            val len = min(m - i0, n - j0)
            for (k in 0 until len) {
                result[i0 + k][j0 + k] = lookup.size
                lookup.add(grid[i0 + k][j0 + k])
            }
            lookup.clear()
            for (k in len - 1 downTo 0) {
                result[i0 + k][j0 + k] = abs(result[i0 + k][j0 + k] - lookup.size)
                lookup.add(grid[i0 + k][j0 + k])
            }
        }

        for (j in 0 until n) {
            update(0, j)
        }
        for (i in 1 until m) {
            update(i, 0)
        }
        return result
    }
}
