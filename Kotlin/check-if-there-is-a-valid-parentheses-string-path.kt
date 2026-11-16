package checkifthereisavalidparenthesesstringpath

// Time:  O((m * n) * (m + n) / 32)
// Space: O(n * (m + n) / 32)

class Solution {
    fun hasValidPath(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        if ((m + n - 1) % 2 == 1) {
            return false
        }
        val highMask = (1L shl 36) - 1
        val dp = Array(n + 1) { LongArray(2) }
        for (i in 0 until m) {
            dp[0][0] = if (i == 0) 1L else 0L
            dp[0][1] = 0L
            for (j in 0 until n) {
                val left = dp[j]
                val up = dp[j + 1]
                val or0 = left[0] or up[0]
                val or1 = left[1] or up[1]
                if (grid[i][j] == '(') {
                    up[0] = or0 shl 1
                    up[1] = ((or1 shl 1) or (or0 ushr 63)) and highMask
                } else {
                    up[0] = (or0 ushr 1) or (or1 shl 63)
                    up[1] = or1 ushr 1
                }
            }
        }
        return (dp[n][0] and 1L) != 0L
    }
}
