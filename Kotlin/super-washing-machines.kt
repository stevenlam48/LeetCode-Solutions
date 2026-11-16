package superwashingmachines

import kotlin.math.abs
import kotlin.math.max

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMinMoves(machines: IntArray): Int {
        val sum = machines.sum()
        if (sum % machines.size != 0) {
            return -1
        }

        var result = 0
        val target = sum / machines.size
        var curr = 0
        for (n in machines) {
            curr += n - target
            result = max(result, max(n - target, abs(curr)))
        }
        return result
    }
}
