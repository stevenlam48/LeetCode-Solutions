package maxdotproductoftwosubsequences

// Time:  O(m * n)
// Space: O(min(m, n))

class Solution {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        if (nums1.size < nums2.size) {
            return maxDotProduct(nums2, nums1)
        }
        val dp = Array(2) { LongArray(nums2.size) }
        for (i in nums1.indices) {
            for (j in nums2.indices) {
                dp[i % 2][j] = nums1[i].toLong() * nums2[j]
                if (i > 0 && j > 0) {
                    dp[i % 2][j] += maxOf(dp[(i - 1) % 2][j - 1], 0L)
                }
                if (i > 0) {
                    dp[i % 2][j] = maxOf(dp[i % 2][j], dp[(i - 1) % 2][j])
                }
                if (j > 0) {
                    dp[i % 2][j] = maxOf(dp[i % 2][j], dp[i % 2][j - 1])
                }
            }
        }
        return dp[(nums1.size - 1) % 2].last().toInt()
    }
}
