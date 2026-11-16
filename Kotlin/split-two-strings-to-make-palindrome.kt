package splittwostringstomakepalindrome

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkPalindromeFormation(a: String, b: String): Boolean {
        return check(a, b) || check(b, a)
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            ++i
            --j
        }
        return true
    }

    private fun check(a: String, b: String): Boolean {
        var i = 0
        var j = b.length - 1
        while (i < j) {
            if (a[i] != b[j]) {
                return isPalindrome(a, i, j) || isPalindrome(b, i, j)
            }
            ++i
            --j
        }
        return true
    }
}
