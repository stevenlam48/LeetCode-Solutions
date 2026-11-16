package maximumlengthofrepeatedsubarray

// Time:  O(m * n)
// Space: O(min(m, n))

class Solution {
    fun findLength(a: IntArray, b: IntArray): Int {
        if (a.size < b.size) {
            return findLength(b, a)
        }
        var result = 0
        val dp = Array(2) { IntArray(b.size + 1) }
        for (i in a.indices) {
            for (j in b.indices) {
                if (a[i] == b[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1
                    result = maxOf(result, dp[(i + 1) % 2][j + 1])
                } else {
                    dp[(i + 1) % 2][j + 1] = 0
                }
            }
        }
        return result
    }
}
