package longesthappyprefix

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestPrefix(s: String): String {
        return s.substring(0, getPrefix(s).last() + 1)
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
}
