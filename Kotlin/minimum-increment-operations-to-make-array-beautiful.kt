package minimumincrementoperationstomakearraybeautiful
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minIncrementOperations(nums: IntArray, k: Int): Long {
        val w = 3
        val dp = LongArray(w)
        for (i in nums.indices) {
            var mn = Long.MAX_VALUE
            for (j in i - w until i) {
                mn = minOf(mn, dp[(j % w + w) % w])
            }
            dp[i % w] = mn + maxOf(k - nums[i], 0)
        }
        return dp.minOrNull()!!
    }
}
