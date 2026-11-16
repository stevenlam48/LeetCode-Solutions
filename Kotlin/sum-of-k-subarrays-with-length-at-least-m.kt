package sumofksubarrayswithlengthatleastm

// Time:  O(k * n)
// Space: O(n)

class Solution {
    fun maxSum(nums: IntArray, k: Int, m: Int): Int {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        var dp = IntArray(nums.size + 1) { Int.MIN_VALUE }
        dp[0] = 0
        for (i in 1..k) {
            val newDp = IntArray(nums.size + 1) { Int.MIN_VALUE }
            var mx = Int.MIN_VALUE
            for (j in i * m - 1 until nums.size) {
                mx = maxOf(mx, dp[j - m + 1])
                newDp[j + 1] = prefix[j + 1] - prefix[j - m + 1] + mx
                if (j != i * m - 1) {
                    newDp[j + 1] = maxOf(newDp[j + 1], newDp[j] + nums[j])
                }
            }
            dp = newDp
        }
        return dp.maxOrNull()!!
    }
}
