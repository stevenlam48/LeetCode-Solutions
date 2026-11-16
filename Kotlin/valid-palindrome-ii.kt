package validpalindromeii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right)
            }
            ++left
            --right
        }
        return true
    }

    private fun validPalindrome(s: String, start: Int, end: Int): Boolean {
        var left = start
        var right = end
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            ++left
            --right
        }
        return true
    }
}
