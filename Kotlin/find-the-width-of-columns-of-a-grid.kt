package findthewidthofcolumnsofagrid

// Time:  O(m * n)
// Space: O(1)

// array
class Solution {
    fun findColumnWidth(grid: Array<IntArray>): IntArray {
        fun length(x0: Int): Int {
            var x = x0
            var l = 1
            if (x < 0) {
                x = -x
                ++l
            }
            while (x >= 10) {
                x /= 10
                ++l
            }
            return l
        }

        val result = IntArray(grid[0].size) { Int.MIN_VALUE }
        for (j in grid[0].indices) {
            for (i in grid.indices) {
                result[j] = maxOf(result[j], length(grid[i][j]))
            }
        }
        return result
    }
}
