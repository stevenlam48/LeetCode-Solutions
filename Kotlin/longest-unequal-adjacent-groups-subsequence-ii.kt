package longestunequaladjacentgroupssubsequenceii

// Time:  O(n^2)
// Space: O(n)

// dp, backtracing
class Solution {
    fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
        val dp = Array(n) { intArrayOf(1, -1) }
        for (i in n - 1 downTo 0) {
            val si = words[i]
            for (j in i + 1 until n) {
                if (groups[i] != groups[j] && check(words[j], si)) {
                    val candidate = intArrayOf(dp[j][0] + 1, j)
                    if (candidate[0] > dp[i][0] ||
                        (candidate[0] == dp[i][0] && candidate[1] > dp[i][1])
                    ) {
                        dp[i] = candidate
                    }
                }
            }
        }
        var best = 0
        for (k in dp.indices) {
            if (dp[k][0] > dp[best][0] ||
                (dp[k][0] == dp[best][0] && dp[k][1] > dp[best][1])
            ) {
                best = k
            }
        }
        val result = mutableListOf<String>()
        var i = best
        while (i != -1) {
            result.add(words[i])
            i = dp[i][1]
        }
        return result
    }

    private fun check(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        var cnt = 0
        for (k in s1.indices) {
            if (s1[k] != s2[k]) {
                ++cnt
            }
            if (cnt == 2) {
                return false
            }
        }
        return cnt == 1
    }
}
