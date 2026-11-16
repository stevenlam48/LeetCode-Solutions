package repeatedsubstringpattern
// Time:  O(n)
// Space: O(n)

class Solution {
    fun repeatedSubstringPattern(str: String): Boolean {
        val prefix = getPrefix(str)
        return prefix.last() != -1 &&
            (prefix.last() + 1) % (str.length - prefix.last() - 1) == 0
    }

    private fun getPrefix(pattern: String): IntArray {
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
