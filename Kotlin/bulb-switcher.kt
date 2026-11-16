package bulbswitcher

// Time:  O(1)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun bulbSwitch(n: Int): Int {
        return sqrt(n.toDouble()).toInt()
    }
}
