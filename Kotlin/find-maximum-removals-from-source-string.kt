package findmaximumremovalsfromsourcestring

// Time:  O(n * m)
// Space: O(n + m)

class Solution {
    fun maxRemovals(source: String, pattern: String, targetIndices: IntArray): Int {
        val NEG_INF = Int.MIN_VALUE

        val dp = IntArray(pattern.length + 1) { NEG_INF }
        dp[0] = 0
        val lookup = BooleanArray(source.length)
        for (x in targetIndices) {
            lookup[x] = true
        }
        for (i in source.indices) {
            for (j in pattern.length downTo 0) {
                if (dp[j] != NEG_INF) {
                    if (lookup[i]) {
                        dp[j] += 1
                    }
                }
                if (j - 1 >= 0 && pattern[j - 1] == source[i]) {
                    dp[j] = maxOf(dp[j], dp[j - 1])
                }
            }
        }
        return dp[pattern.length]
    }
}
