package deletecolumnstomakesortediii

// Time:  O(n * l^2)
// Space: O(l)
class Solution {
    fun minDeletionSize(A: Array<String>): Int {
        val dp = IntArray(A[0].length) { 1 }
        for (j in A[0].indices) {
            for (i in 0 until j) {
                var k = 0
                while (k < A.size && A[k][i] <= A[k][j]) ++k
                if (k == A.size) dp[j] = maxOf(dp[j], dp[i] + 1)
            }
        }
        return A[0].length - dp.max()
    }
}
