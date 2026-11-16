package breakapalindrome

// Time:  O(n)
// Space: O(1)

class Solution {
    fun breakPalindrome(palindrome: String): String {
        val chars = palindrome.toCharArray()
        for (i in 0 until chars.size / 2) {
            if (chars[i] != 'a') {
                chars[i] = 'a'
                return String(chars)
            }
        }
        if (chars.size >= 2) {
            chars[chars.size - 1] = 'b'
            return String(chars)
        }
        return ""
    }
}
