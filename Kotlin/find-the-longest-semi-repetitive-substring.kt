package findthelongestsemirepetitivesubstring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestSemiRepetitiveSubstring(s: String): Int {
        var result = 0
        var left = 0
        var prev = 0
        for (right in s.indices) {
            if (right - 1 >= 0 && s[right - 1] == s[right]) {
                left = prev
                prev = right
            }
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
