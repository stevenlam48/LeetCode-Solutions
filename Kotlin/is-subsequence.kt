package issubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }

        var i = 0
        for (c in t) {
            if (c == s[i]) {
                ++i
            }
            if (i == s.length) {
                break
            }
        }
        return i == s.length
    }
}
