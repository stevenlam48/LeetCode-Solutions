package partitionarrayformaximumsum

// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
        val w = K + 1
        val dp = IntArray(w)
        for (i in A.indices) {
            var currMax = 0
            for (k in 1..minOf(K, i + 1)) {
                currMax = maxOf(currMax, A[i - k + 1])
                dp[i % w] = maxOf(dp[i % w], (if (i >= k) dp[(i - k) % w] else 0) + currMax * k)
            }
        }
        return dp[(A.size - 1) % w]
    }
}
