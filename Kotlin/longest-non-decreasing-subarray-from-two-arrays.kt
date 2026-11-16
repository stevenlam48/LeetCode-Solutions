package longestnondecreasingsubarrayfromtwoarrays

// Time:  O(n)
// Space: O(1)

// dp
class Solution {
    fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
        var result = 1
        var dp = intArrayOf(1, 1)
        for (i in 0 until nums1.size - 1) {
            dp = intArrayOf(
                maxOf(
                    if (nums1[i] <= nums1[i + 1]) dp[0] + 1 else 1,
                    if (nums2[i] <= nums1[i + 1]) dp[1] + 1 else 1
                ),
                maxOf(
                    if (nums1[i] <= nums2[i + 1]) dp[0] + 1 else 1,
                    if (nums2[i] <= nums2[i + 1]) dp[1] + 1 else 1
                )
            )
            result = maxOf(result, maxOf(dp[0], dp[1]))
        }
        return result
    }
}
