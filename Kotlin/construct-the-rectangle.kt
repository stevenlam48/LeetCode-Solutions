package constructtherectangle

import kotlin.math.sqrt

// Time:  O(1)
// Space: O(1)

class Solution {
    fun constructRectangle(area: Int): IntArray {
        var w = sqrt(area.toDouble()).toInt()
        while (area % w != 0) {
            --w
        }
        return intArrayOf(area / w, w)
    }
}
