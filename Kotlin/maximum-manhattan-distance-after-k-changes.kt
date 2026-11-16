package maximummanhattandistanceafterkchanges

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun maxDistance(s: String, k: Int): Int {
        var result = 0
        var x = 0
        var y = 0
        for (i in s.indices) {
            when (s[i]) {
                'E' -> x++
                'W' -> x--
                'N' -> y++
                'S' -> y--
            }
            result = maxOf(result, minOf(abs(x) + abs(y) + 2 * k, i + 1))
        }
        return result
    }
}
