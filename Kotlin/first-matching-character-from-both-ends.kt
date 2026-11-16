package firstmatchingcharacterfrombothends

// Time:  O(n)
// Space: O(1)

class Solution {
    fun firstMatchingIndex(s: String): Int {
        var i = 0
        while (2 * i < s.length) {
            if (s[i] == s[s.length - 1 - i]) {
                return i
            }
            ++i
        }
        return -1
    }
}
