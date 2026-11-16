package countsubstringswithoutrepeatingcharacter
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfSpecialSubstrings(s: String): Int {
        var result = 0
        var left = 0
        val lookup = IntArray(26) { -1 }
        for (right in s.indices) {
            if (lookup[s[right] - 'a'] >= left) {
                left = lookup[s[right] - 'a'] + 1
            }
            lookup[s[right] - 'a'] = right
            result += right - left + 1
        }
        return result
    }
}
