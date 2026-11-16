package longestalmostpalindromicsubstring

// Time:  O(n^2)
// Space: O(1)

// two pointers
class Solution {
    fun almostPalindromic(s: String): Int {
        fun expand(left0: Int, right0: Int): Pair<Int, Int> {
            var left = left0
            var right = right0
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                --left
                ++right
            }
            return left to right
        }

        var result = 0
        for (i in 0 until 2 * s.length - 1) {
            val (left0, right0) = expand(i / 2, (i + 1) / 2)
            for ((left, right) in listOf(left0 - 1 to right0, left0 to right0 + 1)) {
                val (l, r) = expand(left, right)
                result = maxOf(result, minOf((r - l + 1) - 2, s.length))
            }
        }
        return result
    }
}
