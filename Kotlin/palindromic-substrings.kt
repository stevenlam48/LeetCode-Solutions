package palindromicsubstrings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countSubstrings(s: String): Int {
        var result = 0
        for (maxLen in manacher(s)) {
            result += (maxLen + 1) / 2
        }
        return result
    }

    private fun manacher(s: String): IntArray {
        val t = preProcess(s)
        val n = t.length
        val p = IntArray(n)
        var c = 0
        var r = 0
        for (i in 1 until n - 1) {
            val iMirror = 2 * c - i
            p[i] = if (r > i) minOf(r - i, p[iMirror]) else 0
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++
            }
            if (i + p[i] > r) {
                c = i
                r = i + p[i]
            }
        }
        return p
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
