package passthepillow

// Time:  O(1)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun passThePillow(n: Int, time: Int): Int {
        return n - abs((n - 1) - (time % (2 * (n - 1))))
    }
}
