package lexicographicallysmallestgeneratedstring

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun generateString(str1: String, str2: String): String {
        val getPrefix = { pattern: String ->
            val prefix = IntArray(pattern.length) { -1 }
            var j = -1
            for (i in 1 until pattern.length) {
                while (j > -1 && pattern[j + 1] != pattern[i]) {
                    j = prefix[j]
                }
                if (pattern[j + 1] == pattern[i]) {
                    ++j
                }
                prefix[i] = j
            }
            prefix
        }

        val n = str1.length
        val m = str2.length
        val candidate = CharArray(n + m - 1) { '*' }
        var prefix = getPrefix(str2)
        var prev = -m
        for (i in 0 until n) {
            if (str1[i] != 'T') {
                continue
            }
            val diff = i - prev
            if (diff < m) {
                if (prefix[m - 1] + 1 == m - diff) {
                    for (j in 0 until diff) {
                        candidate[(prev + m) + j] = str2[m - diff + j]
                    }
                } else {
                    return ""
                }
            } else {
                for (j in 0 until m) {
                    candidate[i + j] = str2[j]
                }
            }
            prev = i
        }
        val result = (str2 + '#' + String(candidate)).toCharArray()
        val idxs = ArrayList<Int>()
        for (i in m + 1 until result.size) {
            if (result[i] == '*') {
                result[i] = 'a'
                idxs.add(i)
            }
        }
        prefix = getPrefix(String(result))
        val dq = java.util.ArrayDeque<Int>()
        var i = m + 1
        var j = 0
        while (i - (m + 1) < n) {
            while (dq.isNotEmpty() && dq.peekFirst() < i) {
                dq.pollFirst()
            }
            while (j < idxs.size && idxs[j] <= i + (m - 1)) {
                dq.addLast(idxs[j])
                ++j
            }
            if (str1[i - (m + 1)] == 'F' && prefix[i + (m - 1)] + 1 == m) {
                if (dq.isEmpty()) {
                    return ""
                }
                result[dq.peekLast()] = 'b'
                i += m
            } else {
                ++i
            }
        }
        return String(result, m + 1, result.size - (m + 1))
    }
}
