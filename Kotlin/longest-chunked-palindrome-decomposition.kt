package longestchunkedpalindromedecomposition

// Time:  O(n)
// Space: O(1)

// Rabin-Karp Algorithm
class Solution {
    fun longestDecomposition(text: String): Int {
        val mod = 1000000007L
        val d = 26L
        var result = 0
        var left = 0L
        var right = 0L
        var l = 0
        var powD = 1L
        for (i in text.indices) {
            left = (d * left + (text[i] - 'a')) % mod
            right = (powD * (text[text.length - 1 - i] - 'a') + right) % mod
            ++l
            powD = (powD * d) % mod
            if (left == right && compare(text, l, i - l + 1, text.length - 1 - i)) {
                ++result
                left = 0
                right = 0
                l = 0
                powD = 1
            }
        }
        return result
    }

    private fun compare(text: String, l: Int, s1: Int, s2: Int): Boolean {
        for (i in 0 until l) {
            if (text[s1 + i] != text[s2 + i]) {
                return false
            }
        }
        return true
    }
}
