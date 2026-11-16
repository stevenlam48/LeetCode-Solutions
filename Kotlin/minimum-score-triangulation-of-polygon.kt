package minimumscoretriangulationofpolygon

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun minScoreTriangulation(A: IntArray): Int {
        val dp = Array(A.size) { IntArray(A.size) }
        for (p in 3..A.size) {
            for (i in 0..A.size - p) {
                val j = i + p - 1
                dp[i][j] = Int.MAX_VALUE
                for (k in i + 1 until j) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k])
                }
            }
        }
        return dp[0][A.size - 1]
    }
}
