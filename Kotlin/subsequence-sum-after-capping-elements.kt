package subsequencesumaftercappingelements

// Time:  O(nlogn + n * k + klogn) = O(nlogn + n * k)
// Space: O(k)

// sort, dp, bitmasks
class Solution {
    fun subsequenceSumAfterCapping(nums: IntArray, k: Int): List<Boolean> {
        val MAX_K = 4000
        nums.sort()
        val n = nums.size
        val result = BooleanArray(n)
        val dp = BooleanArray(maxOf(k, MAX_K) + 1)
        dp[0] = true
        var i = 0
        for (x in 1..n) {
            while (i < n && nums[i] < x) {
                val v = nums[i]
                for (j in dp.size - 1 downTo v) {
                    dp[j] = dp[j] || dp[j - v]
                }
                ++i
            }
            var j = maxOf(k % x, k - (n - i) * x)
            while (j <= k) {
                if (dp[j]) {
                    result[x - 1] = true
                }
                j += x
            }
        }
        return result.toList()
    }
}
