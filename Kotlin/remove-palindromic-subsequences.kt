package removepalindromicsubsequences

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removePalindromeSub(s: String): Int {
        return 2 - (if (isPalindrome(s)) 1 else 0) - (if (s.isEmpty()) 1 else 0)
    }

    private fun isPalindrome(s: String): Boolean {
        for (i in 0 until s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
