package minimumoperationstoformsubsetsumii

// Time:  O(n * s * logr * logs)
// Space: O(s + logr * logs)

// knapsack dp
class Solution {
    fun minOperations(nums: IntArray, sum: Int): Int {
        val INF = Int.MAX_VALUE

        var dp = IntArray(sum + 1) { INF }
        dp[0] = 0
        for (x in nums) {
            val lookup = IntArray(sum + 1) { INF }
            var nx1 = x
            var c1 = 0
            while (nx1 != 0) {
                var nx2 = nx1
                var c2 = c1
                while (nx2 <= sum) {
                    if (c2 < lookup[nx2]) {
                        lookup[nx2] = c2
                    }
                    nx2 = nx2 shl 1
                    ++c2
                }
                nx1 = nx1 shr 1
                ++c1
            }
            val newDp = dp.copyOf()
            for (nx in 1 until lookup.size) {
                if (lookup[nx] == INF) {
                    continue
                }
                val c = lookup[nx]
                for (i in nx until dp.size) {
                    if (dp[i - nx] == INF) {
                        continue
                    }
                    if (dp[i - nx] + c < newDp[i]) {
                        newDp[i] = dp[i - nx] + c
                    }
                }
            }
            dp = newDp
        }
        return if (dp[sum] != INF) dp[sum] else -1
    }
}
