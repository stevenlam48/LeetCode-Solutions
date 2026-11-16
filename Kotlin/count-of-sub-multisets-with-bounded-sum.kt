package countofsubmultisetswithboundedsum

// Time:  O(n + d * r), d = len(set(nums))
// Space: O(d + r)

// freq table, knapsack dp, sliding window, combinatorics
class Solution {
    fun countSubMultisets(nums: IntArray, l: Int, r: Int): Int {
        val MOD = 1_000_000_007L

        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        val dp = LongArray(r + 1)
        dp[0] = 1
        for ((x, c) in cnt) {
            var i = r
            val lowerBound = maxOf(r - x + 1, 1)
            while (i >= lowerBound) {
                var curr = 0L
                var j = 0
                while (j < c) {
                    if (i - x * j < 0) {
                        break
                    }
                    curr = (curr + dp[i - x * j]) % MOD
                    ++j
                }
                var jj = i
                while (jj >= 1) {
                    if (jj - x * c >= 0) {
                        curr = (curr + dp[jj - x * c]) % MOD
                    }
                    curr = ((curr - dp[jj]) % MOD + MOD) % MOD
                    dp[jj] = (dp[jj] + curr) % MOD
                    jj -= x
                }
                --i
            }
        }
        var result = 0L
        for (i in l..r) {
            result = (result + dp[i]) % MOD
        }
        return ((result * ((cnt[0] ?: 0) + 1)) % MOD).toInt()
    }
}
