package lengthofthelongestsubsequencethatsumstotarget

// Time:  O(n * t)
// Space: O(t)

class Solution {
    fun lengthOfLongestSubsequence(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1) { -1 }
        dp[0] = 0
        for (x in nums) {
            for (i in dp.size - 1 downTo 0) {
                if (i - x >= 0 && dp[i - x] != -1) {
                    dp[i] = maxOf(dp[i], dp[i - x] + 1)
                }
            }
        }
        return dp[target]
    }
}
