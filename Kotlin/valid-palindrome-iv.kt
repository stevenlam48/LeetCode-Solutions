package validpalindromeiv

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makePalindrome(s: String): Boolean {
        var cnt = 0
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                ++cnt
                if (cnt > 2) {
                    return false
                }
            }
            ++left
            --right
        }
        return true
    }
}
