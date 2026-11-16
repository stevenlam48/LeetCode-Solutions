package longestcommonprefixafteratmostoneremoval

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestCommonPrefix(s: String, t: String): Int {
        var result = 0
        var removed = false
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                ++result
                ++i
                ++j
            } else if (!removed) {
                removed = true
                ++i
            } else {
                break
            }
        }
        return result
    }
}
