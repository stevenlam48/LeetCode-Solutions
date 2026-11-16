package anglebetweenhandsofaclock

// Time:  O(1)
// Space: O(1)

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun angleClock(hour: Int, minutes: Int): Double {
        val angle1 = (hour % 12 * 60 + minutes) / 720.0
        val angle2 = minutes / 60.0
        val diff = abs(angle1 - angle2)
        return min(diff, 1.0 - diff) * 360.0
    }
}
