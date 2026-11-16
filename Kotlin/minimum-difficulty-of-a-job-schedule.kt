package minimumdifficultyofajobschedule
// Time:  O(d * n^2)
// Space: O(d * n)

class Solution {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        if (jobDifficulty.size < d) {
            return -1
        }
        val dp = Array(d) { IntArray(jobDifficulty.size) { Int.MAX_VALUE } }
        dp[0][0] = jobDifficulty[0]
        for (i in 1 until jobDifficulty.size) {
            dp[0][i] = maxOf(dp[0][i - 1], jobDifficulty[i])
        }
        for (i in 1 until d) {
            for (j in i until jobDifficulty.size) {
                var currMax = jobDifficulty[j]
                for (k in j downTo i) {
                    currMax = maxOf(currMax, jobDifficulty[k])
                    if (dp[i - 1][k - 1] != Int.MAX_VALUE) {
                        dp[i][j] = minOf(dp[i][j], dp[i - 1][k - 1] + currMax)
                    }
                }
            }
        }
        return dp[d - 1][jobDifficulty.size - 1]
    }
}
