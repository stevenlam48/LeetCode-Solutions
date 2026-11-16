package palindromepartitioningiv
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun checkPartitioning(s: String): Boolean {
        val p = manacher(s)
        val prefix = mutableListOf<Int>()
        val suffix = mutableListOf<Int>()
        for (i in 2 until p.size - 2) {
            if (i - 1 - p[i] == 0) {
                prefix.add(i)
            }
            if (i + 1 + p[i] == p.size - 1) {
                suffix.add(i)
            }
        }
        for (i in prefix) {
            for (j in suffix) {
                val left = i + 1 + p[i]
                val right = j - 1 - p[j]
                if (left > right) {
                    continue
                }
                val mid = left + (right - left) / 2
                if (p[mid] >= mid - left) {
                    return true
                }
            }
        }
        return false
    }

    private fun manacher(s: String): IntArray {
        val t = preProcess(s)
        val p = IntArray(t.length)
        var center = 0
        var right = 0
        for (i in 1 until t.length - 1) {
            val mirror = 2 * center - i
            p[i] = if (right > i) minOf(right - i, p[mirror]) else 0
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++
            }
            if (i + p[i] > right) {
                center = i
                right = i + p[i]
            }
        }
        return p
    }

    private fun preProcess(s: String): String {
        if (s.isEmpty()) {
            return "^$"
        }
        return buildString {
            append('^')
            for (c in s) {
                append('#')
                append(c)
            }
            append("#$")
        }
    }
}
