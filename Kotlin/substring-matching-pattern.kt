package substringmatchingpattern

// Time:  O(n + m)
// Space: O(m)

// kmp
class Solution {
    fun hasMatch(s: String, p: String): Boolean {
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

        fun kmp(text: String, pattern: String, start: Int): Int {
            val prefix = getPrefix(pattern)
            var j = -1
            var i = start
            while (i < text.length) {
                while (j > -1 && pattern[j + 1] != text[i]) {
                    j = prefix[j]
                }
                if (pattern[j + 1] == text[i]) {
                    ++j
                }
                if (j == pattern.length - 1) {
                    return i - j
                }
                ++i
            }
            return -1
        }

        val pp = p + "*"
        var j = 0
        var k = 0
        for (i in pp.indices) {
            if (pp[i] != '*') {
                continue
            }
            val pattern = pp.substring(j, i)
            j = i + 1
            if (pattern.isEmpty()) {
                continue
            }
            k = kmp(s, pattern, k)
            if (k == -1) {
                return false
            }
            k += pattern.length
        }
        return true
    }
}
