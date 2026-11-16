package longestpalindromicsubstring

// Time:  O(n)
// Space: O(n)

// Manacher's Algorithm.
class Solution {
    fun longestPalindrome(s: String): String {
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
        var maxI = 0
        for (i in 1 until n - 1) {
            if (P[i] > P[maxI]) {
                maxI = i
            }
        }
        val start = (maxI - P[maxI]) / 2
        return s.substring(start, start + P[maxI])
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
}
