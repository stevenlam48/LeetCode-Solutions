package maximumnumberofremovalqueriesthatcanbeprocessedi

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun maximumProcessableQueries(nums: IntArray, queries: IntArray): Int {
        val n = nums.size
        val dp = Array(n) { IntArray(n) { Int.MIN_VALUE } }
        dp[0][n - 1] = 0
        for (l in n - 1 downTo 1) {
            for (i in 0 until n - (l - 1)) {
                val j = i + (l - 1)
                if (i - 1 >= 0) {
                    dp[i][j] = maxOf(dp[i][j], dp[i - 1][j] + (if (nums[i - 1] >= queries[dp[i - 1][j]]) 1 else 0))
                }
                if (j + 1 < n) {
                    dp[i][j] = maxOf(dp[i][j], dp[i][j + 1] + (if (nums[j + 1] >= queries[dp[i][j + 1]]) 1 else 0))
                }
                if (dp[i][j] == queries.size) {
                    return queries.size
                }
            }
        }
        var result = 0
        for (i in 0 until n) {
            result = maxOf(result, dp[i][i] + (if (nums[i] >= queries[dp[i][i]]) 1 else 0))
        }
        return result
    }
}
