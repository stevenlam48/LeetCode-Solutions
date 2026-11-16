package shortestpalindrome

// Time:  O(n)
// Space: O(n)

class Solution {
    fun shortestPalindrome(s: String): String {
        if (s.isEmpty()) {
            return s
        }
        val revS = s.reversed()
        val a = s + "#" + revS
        val prefix = getPrefix(a)
        val nonPalindrome = s.substring(prefix.last() + 1).reversed()
        return nonPalindrome + s
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
