package checkasciipalindromic

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isPalindromic(s: String): Boolean {
        fun reverse(x: Int): Int {
            var value = x
            var result = 0
            repeat(8) {
                result = (result shl 1) or (value and 1)
                value = value shr 1
            }
            return result
        }

        for (i in 0 until (s.length + 1) / 2) {
            if (s[i].code != reverse(s[s.length - 1 - i].code)) {
                return false
            }
        }
        return true
    }
}
