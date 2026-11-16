package righttriangles
// Time:  O(n * m)
// Space: O(min(n, m))

class Solution {
    fun numberOfRightTriangles(grid: Array<IntArray>): Long {
        val n = grid.size
        val m = grid[0].size
        fun get(i: Int, j: Int): Int = if (n < m) grid[i][j] else grid[j][i]
        val minSize = minOf(n, m)
        val maxSize = maxOf(n, m)
        val count1 = IntArray(minSize)
        for (i in 0 until minSize) {
            for (j in 0 until maxSize) count1[i] += get(i, j)
        }
        var result = 0L
        for (j in 0 until maxSize) {
            var count2 = 0
            for (i in 0 until minSize) count2 += get(i, j)
            for (i in 0 until minSize) {
                if (get(i, j) != 0) result += (count1[i] - 1L) * (count2 - 1L)
            }
        }
        return result
    }
}
