package findfirstpalindromicstringinthearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun firstPalindrome(words: Array<String>): String {
        for (w in words) {
            if (isPalindrome(w)) {
                return w
            }
        }
        return ""
    }

    private fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false
            }
        }
        return true
    }
}
