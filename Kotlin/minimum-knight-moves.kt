package minimumknightmoves

// Time:  O(1)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minKnightMoves(x: Int, y: Int): Int {
        var a = abs(x)
        var b = abs(y)
        if (a < b) {
            a = b.also { b = a }
        }
        val lookup = mapOf((1 to 0) to 3, (2 to 2) to 4)
        lookup[a to b]?.let { return it }
        val k = a - b
        if (b > k) {
            return k + 2 * ((b - k - 1) / 3 + 1)
        }
        return k - 2 * ((k - b) / 4)
    }
}
