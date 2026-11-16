package minimumfallingpathsum

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun minFallingPathSum(A: Array<IntArray>): Int {
        val n = A.size
        for (i in 1 until n) {
            for (j in 0 until n) {
                var best = Int.MAX_VALUE
                for (k in maxOf(0, j - 1)..minOf(j + 1, n - 1)) {
                    best = minOf(best, A[i - 1][k])
                }
                A[i][j] += best
            }
        }
        return A[n - 1].minOrNull()!!
    }
}
