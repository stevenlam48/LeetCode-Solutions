package longestpalindromeaftersubstringconcatenationi

// Time:  O(n * m)
// Space: O(n + m)

// manacher's algorithm, dp
class Solution {
    fun longestPalindrome(s: String, t0: String): Int {
        val t = t0.reversed()
        val p1 = longestPalindromeArray(s)
        val p2 = longestPalindromeArray(t)
        var result = 0
        val dp = Array(s.length + 1) { IntArray(t.length + 1) }
        for (i in s.indices) {
            for (j in t.indices) {
                dp[i + 1][j + 1] = if (s[i] == t[j]) dp[i][j] + 2 else 0
                val extra = if (s[i] == t[j]) 1 else 0
                result = maxOf(result, dp[i + 1][j + 1] + maxOf(p1[i + extra], p2[j + extra]))
            }
        }
        return result
    }

    private fun manacher(s: String): IntArray {
        val T = preProcess(s)
        val n = T.length
        val P = IntArray(n)
        var C = 0
        var R = 0
        for (i in 1 until n - 1) {
            val iMirror = 2 * C - i
            P[i] = if (R > i) minOf(R - i, P[iMirror]) else 0
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                ++P[i]
            }
            if (i + P[i] > R) {
                C = i
                R = i + P[i]
            }
        }
        return P
    }

    private fun preProcess(s: String): String {
        if (s.isEmpty()) {
            return "^$"
        }
        val ret = StringBuilder("^")
        for (i in s.indices) {
            ret.append('#').append(s[i])
        }
        ret.append("#$")
        return ret.toString()
    }

    private fun longestPalindromeArray(s: String): IntArray {
        val result = IntArray(s.length + 1)
        val P = manacher(s)
        for (i in 1 until P.size - 1) {
            result[(i - P[i]) / 2] = P[i]
        }
        return result
    }
}
