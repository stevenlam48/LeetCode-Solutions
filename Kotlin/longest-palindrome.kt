package longestpalindrome

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestPalindrome(s: String): Int {
        var odds = 0
        for (c in 'A'..'z') {
            odds += (s.count { it == c } and 1)
        }
        return s.length - odds + if (odds > 0) 1 else 0
    }
}
