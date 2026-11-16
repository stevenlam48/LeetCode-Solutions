package maximalsquare

// Time:  O(n^2)
// Space: O(n)

// DP with rolling window.
class Solution {
    fun maximalSquare(A: Array<CharArray>): Int {
        if (A.isEmpty()) {
            return 0
        }
        val m = A.size
        val n = A[0].size
        val size = Array(2) { IntArray(n) }
        var maxSize = 0

        for (j in 0 until n) {
            size[0][j] = A[0][j] - '0'
            maxSize = maxOf(maxSize, size[0][j])
        }
        for (i in 1 until m) {
            size[i % 2][0] = A[i][0] - '0'
            for (j in 1 until n) {
                if (A[i][j] == '1') {
                    size[i % 2][j] = minOf(
                        size[i % 2][j - 1],
                        minOf(size[(i - 1) % 2][j], size[(i - 1) % 2][j - 1])
                    ) + 1
                    maxSize = maxOf(maxSize, size[i % 2][j])
                } else {
                    size[i % 2][j] = 0
                }
            }
        }
        return maxSize * maxSize
    }
}
