package determineifacellisreachableatagiventime

import kotlin.math.abs
import kotlin.math.min

// Time:  O(1)
// Space: O(1)

class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val diff1 = abs(sx - fx)
        val diff2 = abs(sy - fy)
        val mn = min(diff1, diff2) + abs(diff1 - diff2)
        return if (mn != 0) t >= mn else t != 1
    }
}
