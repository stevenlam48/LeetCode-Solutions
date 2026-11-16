package maximummultiplicationscore

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(a: IntArray, b: IntArray): Long {
        val negInf = Long.MIN_VALUE
        val dp = LongArray(a.size + 1) { negInf }
        dp[0] = 0L
        for (x in b) {
            for (i in dp.size - 1 downTo 1) {
                if (dp[i - 1] != negInf) {
                    dp[i] = maxOf(dp[i], dp[i - 1] + x.toLong() * a[i - 1])
                }
            }
        }
        return dp.last()
    }
}
