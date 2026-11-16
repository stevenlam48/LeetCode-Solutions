package numberofwaystoseparatenumbers

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun numberOfCombinations(num: String): Int {
        val mod = 1_000_000_007L
        val lcp = findLongestCommonPrefix(num)
        val dp = Array(num.length) { LongArray(num.length) }
        dp[0][0] = if (num[0] != '0') 1L else 0L
        for (i in 1 until num.length) {
            dp[i][i] = dp[i - 1][i - 1]
            if (num[i] == '0') {
                continue
            }
            var l = 1
            var accu = 0
            while (i + l - 1 < num.length) {
                val ni = i + l - 1
                dp[ni][l - 1] = accu.toLong()
                if (i - l >= 0) {
                    if (num[i - l] != '0' && isLessOrEqualToWithSameLength(num, lcp, i - l, i, l)) {
                        dp[ni][l - 1] = (dp[ni][l - 1] + dp[i - 1][l - 1]) % mod
                    }
                    accu = ((accu + dp[i - 1][l - 1]) % mod).toInt()
                }
                ++l
            }
        }
        var result = 0
        for (value in dp[num.lastIndex]) {
            result = ((result + value) % mod).toInt()
        }
        return result
    }

    private fun findLongestCommonPrefix(num: String): Array<LongArray> {
        val lcp = Array(num.length + 1) { LongArray(num.length + 1) }
        for (i in lcp.lastIndex - 1 downTo 0) {
            for (j in lcp[i].lastIndex - 1 downTo 0) {
                if (num[i] == num[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1
                }
            }
        }
        return lcp
    }

    private fun isLessOrEqualToWithSameLength(
        num: String,
        lcp: Array<LongArray>,
        i: Int,
        j: Int,
        l: Int
    ): Boolean {
        return lcp[i][j] >= l || num[i + lcp[i][j].toInt()] < num[j + lcp[i][j].toInt()]
    }
}
