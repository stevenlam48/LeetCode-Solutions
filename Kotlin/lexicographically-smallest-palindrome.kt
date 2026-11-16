package lexicographicallysmallestpalindrome

// Time:  O(n)
// Space: O(1)

class Solution {
    fun makeSmallestPalindrome(s: String): String {
        val chars = s.toCharArray()
        for (i in 0 until chars.size / 2) {
            val c = minOf(chars[i], chars[(chars.size - 1) - i])
            chars[i] = c
            chars[(chars.size - 1) - i] = c
        }
        return String(chars)
    }
}
