package applyoperationstomakesumofarraygreaterthanorequaltok

// Time:  O(logn)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun minOperations(k: Int): Int {
        val x = sqrt(k.toDouble()).toInt()
        return (x - 1) + ((k + x - 1) / x - 1)
    }
}
