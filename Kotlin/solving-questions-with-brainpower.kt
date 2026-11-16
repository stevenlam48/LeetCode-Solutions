package solvingquestionswithbrainpower

// Time:  O(n)
// Space: O(n)

class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val dp = LongArray(questions.size + 1)
        for (i in dp.size - 2 downTo 0) {
            dp[i] = maxOf(
                dp[i + 1],
                questions[i][0] + (if (i + 1 + questions[i][1] < dp.size) dp[i + 1 + questions[i][1]] else 0L)
            )
        }
        return dp[0]
    }
}
