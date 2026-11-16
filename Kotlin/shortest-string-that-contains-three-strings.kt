package shorteststringthatcontainsthreestrings

// Time:  O(l)
// Space: O(l)

class Solution {
    fun minimumString(a: String, b: String, c: String): String {
        val result = listOf(
            merge(a, merge(b, c)), merge(a, merge(c, b)),
            merge(b, merge(a, c)), merge(b, merge(c, a)),
            merge(c, merge(a, b)), merge(c, merge(b, a))
        )
        return result.minWith(compareBy<String> { it.length }.thenBy { it })
    }

    private fun merge(a: String, b: String): String {
        if (kmp(b, a) != -1) {
            return b
        }
        val prefix = getPrefix(b + "#" + a)
        val l = prefix.last() + 1
        return a + b.substring(l)
    }

    private fun getPrefix(pattern: String): IntArray {
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

    private fun kmp(text: String, pattern: String): Int {
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
}
