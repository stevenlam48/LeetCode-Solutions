package minimumxorpathinagrid

// Time:  O(m * n * r), r = max(x for row in grid for x in row)
// Space: O(n * r / 64)

// dp, bitset
class Solution {
    fun minCost(grid: Array<IntArray>): Int {
        val MAX_LEN = 1024

        var dp = Array(grid[0].size) { BooleanArray(MAX_LEN) }
        dp[0][0] = true
        for (i in grid.indices) {
            val newDp = Array(grid[0].size) { BooleanArray(MAX_LEN) }
            for (j in grid[0].indices) {
                for (k in 0 until MAX_LEN) {
                    if (dp[j][k] || (j - 1 >= 0 && newDp[j - 1][k])) {
                        newDp[j][k xor grid[i][j]] = true
                    }
                }
            }
            dp = newDp
        }
        for (i in 0 until MAX_LEN) {
            if (dp.last()[i]) {
                return i
            }
        }
        return -1
    }
}
