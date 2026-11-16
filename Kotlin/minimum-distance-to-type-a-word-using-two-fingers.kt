package minimumdistancetotypeawordusingtwofingers
// Time:  O(26n)
// Space: O(26)

import kotlin.math.abs

class Solution {
    fun minimumDistance(word: String): Int {
        val dp = IntArray(26)
        for (i in 0 until word.length - 1) {
            val b = word[i] - 'A'
            val c = word[i + 1] - 'A'
            for (a in 0 until 26) {
                dp[b] = maxOf(dp[b], dp[a] - distance(a, c) + distance(b, c))
            }
        }
        var result = 0
        for (i in 0 until word.length - 1) {
            result += distance(word[i] - 'A', word[i + 1] - 'A')
        }
        return result - dp.max()
    }

    private fun distance(a: Int, b: Int): Int {
        return abs(a / 6 - b / 6) + abs(a % 6 - b % 6)
    }
}
