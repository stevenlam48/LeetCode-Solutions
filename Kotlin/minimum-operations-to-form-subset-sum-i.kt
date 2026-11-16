package minimumoperationstoformsubsetsumi

// Time:  O(n * s * (logs + logr))
// Space: O(s)

// knapsack dp
class Solution {
    fun minOperations(nums: IntArray, sum: Int): Int {
        val INF = Int.MAX_VALUE

        val dp = IntArray(sum + 1) { INF }
        dp[0] = 0
        for (x in nums) {
            for (i in dp.size - 1 downTo 1) {
                var nx = x
                var c = 0
                while (i - nx >= 0) {
                    if (dp[i - nx] == INF) {
                        nx = nx shl 1
                        ++c
                        continue
                    }
                    if (dp[i - nx] + c < dp[i]) {
                        dp[i] = dp[i - nx] + c
                    }
                    nx = nx shl 1
                    ++c
                }
                nx = x / 2
                c = 1
                while (nx != 0) {
                    if (i - nx < 0 || dp[i - nx] == INF) {
                        nx = nx shr 1
                        ++c
                        continue
                    }
                    if (dp[i - nx] + c < dp[i]) {
                        dp[i] = dp[i - nx] + c
                    }
                    nx = nx shr 1
                    ++c
                }
            }
        }
        return if (dp[sum] != INF) dp[sum] else -1
    }
}
