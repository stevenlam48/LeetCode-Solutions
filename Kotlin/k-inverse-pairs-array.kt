package kinversepairsarray
// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun kInversePairs(n: Int, k: Int): Int {
        val mod = 1_000_000_007
        var dp = intArrayOf(1)
        for (i in 0 until n) {
            val newDp = IntArray(minOf(dp.size + i, k + 1))
            for (j in newDp.indices) {
                newDp[j] = if (j < dp.size) dp[j] else 0
                if (j - 1 >= 0) {
                    newDp[j] = (newDp[j] + newDp[j - 1]) % mod
                }
                if (j - (i + 1) >= 0) {
                    newDp[j] = ((newDp[j] - dp[j - (i + 1)]) % mod + mod) % mod
                }
            }
            dp = newDp
        }
        return if (k < dp.size) dp[k] else 0
    }
}
