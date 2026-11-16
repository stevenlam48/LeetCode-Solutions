package countthenumberofinversions

// Time:  O(n * k), k = max(cnt for _, cnt in requirements)
// Space: O(n + k)

// knapsack dp, combinatorics, sliding window, two pointers
class Solution {
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val MOD = 1_000_000_007L

        val addmod = { a: Long, b: Long -> (a + b) % MOD }
        val submod = { a: Long, b: Long -> ((a - b) % MOD + MOD) % MOD }

        val lookup = IntArray(n) { -1 }
        for (r in requirements) {
            lookup[r[0]] = r[1]
        }
        var dp = mutableListOf(1L)
        var prev = 0
        for (i in 0 until n) {
            if (lookup[i] != -1) {
                val from = maxOf((lookup[i] - i) - prev, 0)
                val to = minOf((lookup[i] + 1) - prev, dp.size)
                var sum = 0L
                for (idx in from until to) {
                    sum = addmod(sum, dp[idx])
                }
                dp = mutableListOf(sum)
                prev = lookup[i]
                continue
            }
            val newSize = minOf(dp.size + i, (lookup[n - 1] + 1) - prev)
            val newDp = MutableList(newSize) { 0L }
            for (j in 0 until newSize) {
                newDp[j] = if (j < dp.size) dp[j] else 0L
                if (j - 1 >= 0) {
                    newDp[j] = addmod(newDp[j], newDp[j - 1])
                }
                if (j - (i + 1) >= 0) {
                    newDp[j] = submod(newDp[j], dp[j - (i + 1)])
                }
            }
            dp = newDp
        }
        return dp.last().toInt()
    }
}
