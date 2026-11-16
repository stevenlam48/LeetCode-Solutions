package reachanumber
// Time:  O(logn)
// Space: O(1)
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

class Solution {
    fun reachNumber(target: Int): Int {
        var remaining = abs(target)
        val k = ceil((-1 + sqrt(1 + 8.0 * remaining)) / 2).toInt()
        remaining -= k * (k + 1) / 2
        return if (remaining % 2 == 0) k else k + 1 + k % 2
    }
}
