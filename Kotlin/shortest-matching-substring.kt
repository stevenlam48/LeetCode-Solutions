package shortestmatchingsubstring

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun shortestMatchingSubstring(s: String, p: String): Int {
        fun getPrefix(pattern: String): IntArray {
            val prefix = IntArray(pattern.length) { -1 }
            var j = -1
            for (i in 1 until pattern.length) {
                while (j != -1 && pattern[j + 1] != pattern[i]) {
                    j = prefix[j]
                }
                if (pattern[j + 1] == pattern[i]) {
                    ++j
                }
                prefix[i] = j
            }
            return prefix
        }

        fun kmp(text: String, pattern: String): IntArray {
            if (pattern.isEmpty()) {
                return IntArray(text.length + 1) { it }
            }
            val prefix = getPrefix(pattern)
            val result = ArrayList<Int>()
            var j = -1
            for (i in text.indices) {
                while (j > -1 && pattern[j + 1] != text[i]) {
                    j = prefix[j]
                }
                if (pattern[j + 1] == text[i]) {
                    ++j
                }
                if (j == pattern.length - 1) {
                    result.add(i - j)
                    j = prefix[j]
                }
            }
            return result.toIntArray()
        }

        val i = p.indexOf('*')
        val a = p.substring(0, i)
        val j = p.indexOf('*', i + 1)
        val b = p.substring(i + 1, j)
        val c = p.substring(j + 1)
        val la = a.length
        val lb = b.length
        val lc = c.length
        var result = Int.MAX_VALUE
        val idxs1 = kmp(s, b)
        val idxs2 = kmp(s, c)
        var x = 0
        var y = 0
        for (start in kmp(s, a)) {
            while (x < idxs1.size && idxs1[x] < start + la) {
                ++x
            }
            if (x == idxs1.size) {
                break
            }
            while (y < idxs2.size && idxs2[y] < idxs1[x] + lb) {
                ++y
            }
            if (y == idxs2.size) {
                break
            }
            result = minOf(result, (idxs2[y] + lc) - start)
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
