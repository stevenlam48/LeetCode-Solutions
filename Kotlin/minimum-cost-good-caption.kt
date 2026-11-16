package minimumcostgoodcaption

// Time:  O(26 * n)
// Space: O(26 * n)

class Solution {
    fun minCostGoodCaption(caption: String): String {
        val L = 3

        val n = caption.length
        if (n < L) {
            return ""
        }
        val dp = Array(n - L + 1) { Array(26) { IntArray(2) } }
        val mn = Array(n - L + 1) { IntArray(2) }
        for (i in n - L downTo 0) {
            for (j in 0 until 26) {
                if (i == n - L) {
                    for (k in i until i + L) {
                        dp[i][j][0] += kotlin.math.abs((caption[k] - 'a') - j)
                    }
                    dp[i][j][1] = L
                    continue
                }
                dp[i][j][0] = dp[i + 1][j][0] + kotlin.math.abs((caption[i] - 'a') - j)
                dp[i][j][1] = 1
                if (i + L < n - 2) {
                    var curr = mn[i + L][0]
                    val c = mn[i + L][1]
                    for (k in i until i + L) {
                        curr += kotlin.math.abs((caption[k] - 'a') - j)
                    }
                    if (curr < dp[i][j][0] || (curr == dp[i][j][0] && c < j)) {
                        dp[i][j][0] = curr
                        dp[i][j][1] = L
                    }
                }
            }
            mn[i][0] = dp[i][0][0]
            mn[i][1] = 0
            for (j in 1 until 26) {
                if (dp[i][j][0] < mn[i][0]) {
                    mn[i][0] = dp[i][j][0]
                    mn[i][1] = j
                }
            }
        }
        val result = StringBuilder()
        var i = 0
        var j = mn[0][1]
        var l = 1
        while (i != n) {
            if (l == L) {
                j = mn[i][1]
            }
            l = dp[i][j][1]
            repeat(l) { result.append('a' + j) }
            i += l
        }
        return result.toString()
    }
}
