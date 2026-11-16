package constructstringwithminimumcosteasy

// Time:  O(n * w * l)
// Space: O(l)

private const val INF = Int.MAX_VALUE

// dp
class Solution {
    fun minimumCost(target: String, words: List<String>, costs: IntArray): Int {
        var l = 0
        for (w in words) {
            l = maxOf(l, w.length)
        }
        val dp = IntArray(l + 1) { INF }
        dp[0] = 0
        for (i in target.indices) {
            if (dp[i % dp.size] == INF) {
                continue
            }
            for (j in words.indices) {
                if (target.startsWith(words[j], i)) {
                    val next = (i + words[j].length) % dp.size
                    dp[next] = minOf(dp[next], dp[i % dp.size] + costs[j])
                }
            }
            dp[i % dp.size] = INF
        }
        return if (dp[target.length % dp.size] != INF) dp[target.length % dp.size] else -1
    }
}
