package shortestdistancetoacharacter

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun shortestToChar(s: String, c: Char): IntArray {
        val result = IntArray(s.length) { s.length }
        var previous = -s.length
        for (i in s.indices) {
            if (s[i] == c) {
                previous = i
            }
            result[i] = minOf(result[i], abs(i - previous))
        }
        for (i in s.length - 1 downTo 0) {
            if (s[i] == c) {
                previous = i
            }
            result[i] = minOf(result[i], abs(i - previous))
        }
        return result
    }
}
