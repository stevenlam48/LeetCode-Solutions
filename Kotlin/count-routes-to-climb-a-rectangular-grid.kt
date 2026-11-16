package countroutestoclimbarectangulargrid

// Time:  O(n * m)
// Space: O(m)

class Solution {
    private val mod = 1_000_000_007

    private fun update(dp: IntArray, d: Int, row: String): IntArray {
        val newDp = IntArray(row.length)
        var current = 0
        for (i in 0 until minOf(d, dp.size)) {
            current = (current + dp[i]) % mod
        }
        for (i in row.indices) {
            if (i - d - 1 >= 0) {
                current = (current - dp[i - d - 1] + mod) % mod
            }
            if (i + d < dp.size) {
                current = (current + dp[i + d]) % mod
            }
            newDp[i] = if (row[i] == '.') current else 0
        }
        return newDp
    }

    fun numberOfRoutes(grid: List<String>, d: Int): Int {
        var dp = IntArray(grid[0].length) { 1 }
        for (i in grid.lastIndex downTo 0) {
            dp = update(dp, if (i != grid.lastIndex) d - 1 else 0, grid[i])
            dp = update(dp, d, grid[i])
        }
        var result = 0
        for (value in dp) {
            result = (result + value) % mod
        }
        return result
    }
}
