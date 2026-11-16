package largestsumofaverages

// Time:  O(k * n^2)
// Space: O(n)

class Solution {
    fun largestSumOfAverages(A: IntArray, K: Int): Double {
        val accumSum = IntArray(A.size)
        accumSum[0] = A[0]
        for (i in 1 until A.size) {
            accumSum[i] = A[i] + accumSum[i - 1]
        }

        val dp = Array(2) { DoubleArray(A.size) }
        for (k in 1..K) {
            for (i in k - 1 until A.size) {
                if (k == 1) {
                    dp[k % 2][i] = accumSum[i].toDouble() / (i + 1)
                } else {
                    for (j in k - 2 until i) {
                        dp[k % 2][i] = maxOf(
                            dp[k % 2][i],
                            dp[(k - 1) % 2][j] +
                                (accumSum[i] - accumSum[j]).toDouble() / (i - j)
                        )
                    }
                }
            }
        }
        return dp[K % 2].last()
    }
}
