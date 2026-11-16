package minimumtotalspacewastedwithkresizingoperations

// Time:  O(k * n^2)
// Space: O(k * n)

class Solution {
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        val INF = Int.MAX_VALUE

        val kk = k + 1
        val dp = Array(nums.size + 1) { IntArray(kk + 1) { INF } }
        dp[0][0] = 0
        for (i in 1..nums.size) {
            var total = 0
            var maxNum = 0
            for (j in i downTo 1) {
                total += nums[j - 1]
                maxNum = maxOf(maxNum, nums[j - 1])
                for (m in 1..kk) {
                    if (dp[j - 1][m - 1] != INF) {
                        dp[i][m] = minOf(dp[i][m], dp[j - 1][m - 1] + (maxNum * (i - j + 1) - total))
                    }
                }
            }
        }
        return dp[nums.size][kk]
    }
}
