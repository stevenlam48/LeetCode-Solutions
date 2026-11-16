package findtheshortestsuperstringii

// Time:  O(n + m)
// Space: O(n + m)

// kmp algorithm
class Solution {
    fun shortestSuperstring(s1: String, s2: String): String {
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

        fun kmp(text: String, pattern: String): String {
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
                    break
                }
            }
            return text + pattern.substring(j + 1)
        }

        val result1 = kmp(s1, s2)
        val result2 = kmp(s2, s1)
        return if (result1.length < result2.length) result1 else result2
    }
}
