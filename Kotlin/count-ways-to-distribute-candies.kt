package countwaystodistributecandies

// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun waysToDistribute(n: Int, k: Int): Int {
        val mod = 1_000_000_007
        val dp = LongArray(k) { 1L }
        for (i in 1 until n) {
            var j = minOf(i, k) - 1
            while (j >= 1) {
                dp[j] = ((j + 1) * dp[j] + dp[j - 1]) % mod
                --j
            }
        }
        return dp[k - 1].toInt()
    }
}
