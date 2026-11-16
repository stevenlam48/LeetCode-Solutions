package constructingtwoincreasingarrays
// Time:  O(m * n)
// Space: O(min(m, n))

class Solution {
    fun minLargest(nums1: IntArray, nums2: IntArray): Int {
        val inf = Int.MAX_VALUE
        var first = nums1
        var second = nums2
        if (first.size < second.size) {
            val temp = first
            first = second
            second = temp
        }
        val dp = IntArray(second.size + 1) { inf }
        dp[0] = 0
        for (i in 0..first.size) {
            for (j in 0..second.size) {
                if (i == 0 && j == 0) {
                    continue
                }
                var curr = inf
                if (i - 1 >= 0 && dp[j] != inf) {
                    curr = minOf(curr, dp[j] + if (dp[j] % 2 == first[i - 1] % 2) 2 else 1)
                }
                if (j - 1 >= 0 && dp[j - 1] != inf) {
                    curr = minOf(curr, dp[j - 1] + if (dp[j - 1] % 2 == second[j - 1] % 2) 2 else 1)
                }
                dp[j] = curr
            }
        }
        return dp.last()
    }
}
