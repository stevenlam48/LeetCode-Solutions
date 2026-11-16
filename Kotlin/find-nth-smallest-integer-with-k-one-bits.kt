package findnthsmallestintegerwithkonebits

// Time:  ctor:    O(r^2)
//        runtime: O(r)
// Space: O(r^2)

class Solution {
    fun nthSmallest(n: Long, k: Int): Long {
        var remainingN = n
        var remainingK = k
        var result = 0L
        for (i in MAX_K - 1 downTo 0) {
            if (remainingN <= DP[i][remainingK]) {
                continue
            }
            remainingN -= DP[i][remainingK]
            result = result or (1L shl i)
            if (--remainingK == 0) {
                break
            }
        }
        return result
    }

    companion object {
        private const val MAX_K = 50
        private val DP = Array(MAX_K + 1) { LongArray(MAX_K + 1) }.also { dp ->
            for (i in dp.indices) {
                dp[i][0] = 1
                for (j in 1..i) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                }
            }
        }
    }
}
