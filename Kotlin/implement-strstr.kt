package implementstrstr

// Time:  O(n + k)
// Space: O(k)

// Wiki of KMP algorithm:
// http://en.wikipedia.org/wiki/Knuth-Morris-Pratt_algorithm
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }

        return KMP(haystack, needle)
    }

    fun KMP(text: String, pattern: String): Int {
        val prefix = getPrefix(pattern)
        var j = -1
        for (i in text.indices) {
            while (j > -1 && pattern[j + 1] != text[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == text[i]) {
                ++j
            }
            if (j == pattern.length - 1) {
                return i - j
            }
        }
        return -1
    }

    fun getPrefix(pattern: String): IntArray {
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
        return prefix
    }
}
