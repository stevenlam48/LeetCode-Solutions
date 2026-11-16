package maximummanhattandistanceafterallmoves

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun maxDistance(moves: String): Int {
        var x = 0
        var y = 0
        var wildcards = 0
        for (c in moves) {
            when (c) {
                'U' -> y++
                'D' -> y--
                'L' -> x--
                'R' -> x++
                else -> wildcards++
            }
        }
        return abs(x) + abs(y) + wildcards
    }
}
