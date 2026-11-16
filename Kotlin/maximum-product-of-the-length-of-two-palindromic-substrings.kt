package maximumproductofthelengthoftwopalindromicsubstrings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxProduct(s: String): Long {
        val p = manacher(s)
        val q = ArrayDeque<Pair<Long, Long>>()
        val left = ArrayList<Long>()
        left.add(0L)
        for (i in s.indices) {
            while (q.isNotEmpty() && q.first().second < i) {
                q.removeFirst()
            }
            left.add(maxOf(left.last(), if (q.isEmpty()) 1L else 1L + 2L * (i - q.first().first)))
            q.addLast(i.toLong() to (i + p[2 * i + 2] / 2).toLong())
        }
        q.clear()
        var result = 0L
        var right = 0L
        for (i in s.length - 1 downTo 0) {
            while (q.isNotEmpty() && q.first().second > i) {
                q.removeFirst()
            }
            right = maxOf(right, if (q.isEmpty()) 1L else 1L + 2L * (q.first().first - i))
            q.addLast(i.toLong() to (i - p[2 * i + 2] / 2).toLong())
            result = maxOf(result, left[i] * right)
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
                ++p[i]
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
