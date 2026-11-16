package lengthofthelongestalphabeticalcontinuoussubstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestContinuousSubstring(s: String): Int {
        var result = 0
        var l = 0
        for (i in s.indices) {
            ++l
            if (i + 1 == s.length || s[i] + 1 != s[i + 1]) {
                result = maxOf(result, l)
                l = 0
            }
        }
        return result
    }
}
