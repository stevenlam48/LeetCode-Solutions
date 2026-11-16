package maximumxorscoresubarrayqueries

// Time:  O(n^2 + q)
// Space: O(n^2)

class Solution {
    fun maximumSubarrayXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val dp = Array(n) { IntArray(n - it) }
        for (i in 0 until n) {
            dp[i][0] = nums[i]
        }
        for (i in n - 1 downTo 0) {
            for (l in 1 until n - i) {
                dp[i][l] = dp[i][l - 1] xor dp[i + 1][l - 1]
            }
        }
        for (i in n - 1 downTo 0) {
            for (l in 1 until n - i) {
                dp[i][l] = maxOf(dp[i][l], dp[i][l - 1], dp[i + 1][l - 1])
            }
        }
        return IntArray(queries.size) {
            dp[queries[it][0]][queries[it][1] - queries[it][0]]
        }
    }
}
