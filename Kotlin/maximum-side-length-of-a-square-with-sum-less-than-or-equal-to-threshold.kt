package maximumsidelengthofasquarewithsumlessthanorequaltothreshold

// Time:  O(m * n * log(min(m, n)))
// Space: O(m * n)

class Solution {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val m = mat.size
        val n = mat[0].size
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1]
            }
        }
        var left = 0
        var right = minOf(m, n)
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(dp, mid, threshold)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(dp: Array<IntArray>, mid: Int, threshold: Int): Boolean {
        for (i in mid until dp.size) {
            for (j in mid until dp[0].size) {
                if (dp[i][j] - dp[i - mid][j] - dp[i][j - mid] + dp[i - mid][j - mid] <= threshold) {
                    return true
                }
            }
        }
        return false
    }
}
