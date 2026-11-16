package validpalindrome

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            if (!isAlnum(s[i])) {
                ++i
            } else if (!isAlnum(s[j])) {
                --j
            } else if (s[i].lowercaseChar() != s[j].lowercaseChar()) {
                return false
            } else {
                ++i
                --j
            }
        }
        return true
    }

    private fun isAlnum(c: Char): Boolean {
        return c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'
    }
}
