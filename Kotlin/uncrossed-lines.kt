package uncrossedlines

// Time:  O(m * n)
// Space: O(min(m, n))

class Solution {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        if (A.size < B.size) {
            return maxUncrossedLines(B, A)
        }
        val dp = Array(2) { IntArray(B.size + 1) }
        for (i in A.indices) {
            for (j in B.indices) {
                dp[(i + 1) % 2][j + 1] = maxOf(
                    dp[i % 2][j] + (if (A[i] == B[j]) 1 else 0),
                    maxOf(dp[i % 2][j + 1], dp[(i + 1) % 2][j])
                )
            }
        }
        return dp[A.size % 2][B.size]
    }
}
