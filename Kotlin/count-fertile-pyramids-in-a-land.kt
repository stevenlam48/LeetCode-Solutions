package countfertilepyramidsinaland

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun countPyramids(grid: Array<IntArray>): Int {
        return count(grid, false) + count(grid, true)
    }

    private fun count(grid: Array<IntArray>, reverse: Boolean): Int {
        fun get(i: Int, j: Int): Int = if (reverse) grid[grid.size - 1 - i][j] else grid[i][j]

        var result = 0
        val cols = grid[0].size
        var dp = IntArray(cols)
        for (i in 1 until grid.size) {
            val newDp = IntArray(cols)
            for (j in 1 until cols - 1) {
                if (get(i, j) == 1 &&
                    get(i - 1, j - 1) == 1 &&
                    get(i - 1, j) == 1 &&
                    get(i - 1, j + 1) == 1
                ) {
                    newDp[j] = minOf(dp[j - 1], dp[j + 1]) + 1
                }
            }
            dp = newDp
            for (v in dp) {
                result += v
            }
        }
        return result
    }
}
