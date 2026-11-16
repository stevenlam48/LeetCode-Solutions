package arithmeticslicesiisubsequence

// Time:  O(n^2)
// Space: O(n * d)

class Solution {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var result = 0
        val dp = Array(A.size) { HashMap<Long, Int>() }
        for (i in 1 until A.size) {
            for (j in 0 until i) {
                val diff = A[i].toLong() - A[j]
                dp[i][diff] = dp[i].getOrDefault(diff, 0) + 1
                val previous = dp[j][diff]
                if (previous != null) {
                    dp[i][diff] = dp[i].getValue(diff) + previous
                    result += previous
                }
            }
        }
        return result
    }
}
